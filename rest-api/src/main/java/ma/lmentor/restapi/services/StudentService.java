package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Student;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.mappers.StudentMapper;
import ma.lmentor.restapi.repositories.StudentRepository;
import ma.lmentor.restapi.vo.StudentProfileVo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private UserService userService;
    private SubcategoryService subcategoryService;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, UserService userService, SubcategoryService subcategoryService) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.userService = userService;
        this.subcategoryService = subcategoryService;
    }

    public void create(StudentProfileVo studentProfileVo) throws NotFoundException {
        var student = studentMapper.toStudent(studentProfileVo);
        var currentUser = userService.getCurrentUser();
        if (currentUser.isEmpty())  throw new NotFoundException("User not found!");
        student.setUser(currentUser.get());
        student.setProfileId(currentUser.get().getProfile().getProfileId());
        student.setProfileCompleted(true);
        var subcategories = subcategoryService.getSubcategories(studentProfileVo.getInterests());
        student.setInterestAreas(subcategories);
        studentRepository.save(student);
    }

    public Student createEmpty(User user) {
        var emptyStudent = new Student(user);
        return studentRepository.save(emptyStudent);
    }
}
