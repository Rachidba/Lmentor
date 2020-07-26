package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.vo.RegistrationDto;
import ma.lmentor.restapi.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationDto registrationDto) {
        this.userService.create(registrationDto);
    }
}
