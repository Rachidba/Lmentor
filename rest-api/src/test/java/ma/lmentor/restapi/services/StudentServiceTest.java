package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Student;
import ma.lmentor.restapi.mappers.StudentMapper;
import ma.lmentor.restapi.repositories.StudentRepository;
import ma.lmentor.restapi.vo.StudentProfileVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private UserService userService;
    @Mock
    private SubcategoryService subcategoryService;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void create_shouldThrowNotFoundException_whenUserNotFound() {
        when(studentMapper.toStudent(any())).thenReturn(new Student());
        when(userService.getCurrentUser()).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,
                () -> studentService.create(new StudentProfileVo()));
    }
}
