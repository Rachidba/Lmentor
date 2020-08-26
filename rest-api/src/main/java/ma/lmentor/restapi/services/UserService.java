package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.repositories.UserRepository;
import ma.lmentor.restapi.security.auth.JwtAuthenticationToken;
import ma.lmentor.restapi.security.model.UserContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> get(String username) {
        return userRepository.findByEmail(username);
    }

    public Optional<User> getCurrentUser() {
        JwtAuthenticationToken auth = (JwtAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        var currentUsername = ((UserContext)auth.getPrincipal()).getUsername();
        return this.get(currentUsername);
    }
}
