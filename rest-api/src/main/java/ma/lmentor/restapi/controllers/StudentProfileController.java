package ma.lmentor.restapi.controllers;

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

@RestController
@RequestMapping("api/v1/students/profile")
public class StudentProfileController {

    private StudentService studentService;

    public StudentProfileController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity updateProfile(@Valid @RequestBody StudentProfileVo studentProfileVo) {
        try {
            studentService.create(studentProfileVo);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
