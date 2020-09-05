package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.lmentor.restapi.exceptions.EmailAlreadyExistsException;
import ma.lmentor.restapi.exceptions.InvalidConfirmationTokenException;
import ma.lmentor.restapi.services.RegistrationService;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;

@RestController
@RequestMapping("api")
@Api(tags = "Registration API")
public class RegistrationController {
    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/auth/register")
    @ApiOperation(value = "Register new user")
    @ApiResponses(value = {
            @ApiResponse(code = SC_CREATED, message = "User created")
    })
    public ResponseEntity register(@Valid @RequestBody RegistrationVo registrationVo) {
        logger.info("Register is called with email: " + registrationVo.getEmail());
        try {
            this.registrationService.register(registrationVo);
            return ResponseEntity.ok().build();
        } catch (EmailAlreadyExistsException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            logger.error(e.toString());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/auth/confirm-email")
    public ResponseEntity confirmEmail(@RequestParam("token")String confirmationsToken) {
        try {
            this.registrationService.confirmEmail(confirmationsToken);
            logger.info("Confirm email called with valid token");
            return ResponseEntity.ok().build();
        } catch (InvalidConfirmationTokenException ex) {
            logger.info("Confirm email called with invalid token");
            return new ResponseEntity(ex.message, HttpStatus.BAD_REQUEST);
        }
    }
}
