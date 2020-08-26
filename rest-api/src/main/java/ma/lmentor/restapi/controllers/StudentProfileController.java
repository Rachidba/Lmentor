package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import ma.lmentor.restapi.services.StudentService;
import ma.lmentor.restapi.vo.StudentProfileVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@RestController
@RequestMapping("api/students/profile")
@Api(tags = "Student profile API")
public class StudentProfileController {

    private StudentService studentService;

    public StudentProfileController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ApiOperation(value = "Update student profile")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Profile updated"),
            @ApiResponse(code = SC_UNAUTHORIZED, message = "User not authorised to do this operation")
    })
    public ResponseEntity updateProfile(@Valid @RequestBody StudentProfileVo studentProfileVo) {
        try {
            studentService.create(studentProfileVo);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
