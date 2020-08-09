package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.lmentor.restapi.exceptions.EmailAlreadyExistsException;
import ma.lmentor.restapi.services.RegistrationService;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Registration API")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(code = SC_CREATED, message = "User created")
    })
    public ResponseEntity register(@Valid @RequestBody RegistrationVo registrationVo) {
        try {
            this.registrationService.register(registrationVo);
            return ResponseEntity.ok().build();
        } catch (EmailAlreadyExistsException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
