package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.models.RegistrationDto;
import ma.lmentor.restapi.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegistrationDto registrationDto) {
        this.userService.create(registrationDto);
    }
}
