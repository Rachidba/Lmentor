package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Student;
import ma.lmentor.restapi.vo.StudentProfileVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void studentProfileVoToStudentTest() {
        final String firstName = "Rachid";
        final String lastName = "BAAZIZ";
        final String contactEmail = "rachid.baaziz@gmail.com";
        final String phoneNumber = "0777445588";
        var studentProfileVo = StudentProfileVo.builder()
                .firstName(firstName)
                .lastName(lastName)
                .contactEmail(contactEmail)
                .phoneNumber(phoneNumber)
                .build();
        var actualStudent = studentMapper.toStudent(studentProfileVo);
        var expectedStudent = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .contactEmail(contactEmail)
                .phoneNumber(phoneNumber)
                .build();
        Assertions.assertEquals(expectedStudent, actualStudent);
    }
}
