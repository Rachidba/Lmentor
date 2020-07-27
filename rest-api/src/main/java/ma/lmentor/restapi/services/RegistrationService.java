package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.exceptions.EmailAlreadyExistsException;
import ma.lmentor.restapi.mappers.UserMapper;
import ma.lmentor.restapi.repositories.UserRepository;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private final ProfileService profileService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistrationService(UserRepository userRepository, ProfileService profileService, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.profileService = profileService;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public User register(RegistrationVo registrationVo) {
        if (userRepository.existsByEmail(registrationVo.getEmail()))
            throw new EmailAlreadyExistsException("Email already used, try with an other email");

        var user = userMapper.toUser(registrationVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        profileService.createEmptyProfile(savedUser);
        return savedUser;
    }
}
