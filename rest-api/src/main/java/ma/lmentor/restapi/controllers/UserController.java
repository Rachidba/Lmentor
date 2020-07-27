package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.services.RegistrationService;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private final RegistrationService registrationService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationVo registrationVo) {
        this.registrationService.register(registrationVo);
    }
}
