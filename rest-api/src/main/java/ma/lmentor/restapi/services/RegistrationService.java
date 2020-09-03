package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.ConfirmationToken;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.exceptions.EmailAlreadyExistsException;
import ma.lmentor.restapi.exceptions.InvalidConfirmationTokenException;
import ma.lmentor.restapi.mappers.UserMapper;
import ma.lmentor.restapi.repositories.IConfirmationTokenRepository;
import ma.lmentor.restapi.repositories.UserRepository;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private final ProfileService profileService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final IConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;

    public RegistrationService(UserRepository userRepository,
                               ProfileService profileService,
                               UserMapper userMapper,
                               BCryptPasswordEncoder bCryptPasswordEncoder,
                               IConfirmationTokenRepository confirmationTokenRepository,
                               EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.profileService = profileService;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
    }

    @Transactional
    public User register(RegistrationVo registrationVo) throws Exception {
        if (userRepository.existsByEmail(registrationVo.getEmail()))
            throw new EmailAlreadyExistsException("Email already used, try with an other email");

        var user = userMapper.toUser(registrationVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        profileService.createEmptyProfile(savedUser);
        sendConfirmationEmail(savedUser);
        return savedUser;
    }

    public void confirmEmail(String confirmationToken) {
        var token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token == null)
            throw new InvalidConfirmationTokenException("The given token is not found");
        var user = userRepository.findByEmail(token.getUser().getEmail()).get();
        user.setEnabled(true);
        userRepository.save(user);
    }

    private void sendConfirmationEmail(User user) throws Exception {
        var confirmationToken = new ConfirmationToken(user);
        confirmationToken = confirmationTokenRepository.save(confirmationToken);
        if (confirmationToken == null)
            throw new Exception("Cannot save confirmation token!");
        var mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Lmentor.ma Complete Registration!");
        mailMessage.setFrom("rachidbaaziz.contact@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://lmentor.ma/confirm-email?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);
    }
}
