package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.mappers.UserMapper;
import ma.lmentor.restapi.models.RegistrationDto;
import ma.lmentor.restapi.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User create(RegistrationDto registrationDto) {
        var user = userMapper.toUser(registrationDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
