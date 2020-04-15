package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.mappers.UserMapper;
import ma.lmentor.restapi.models.RegistrationDto;
import ma.lmentor.restapi.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileService profileService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, ProfileService profileService, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.profileService = profileService;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User create(RegistrationDto registrationDto) {
        var user = userMapper.toUser(registrationDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        profileService.createEmptyProfile(savedUser);
        return savedUser;
    }

    public Optional<User> get(String username) {
        return userRepository.findByUsername(username);
    }
}
