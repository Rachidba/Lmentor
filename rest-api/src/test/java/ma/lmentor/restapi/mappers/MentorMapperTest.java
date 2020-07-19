package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MentorMapperTest {

    @Autowired
    private MentorMapper mentorMapper;

    @Test
    public void creationDtoToMentorTest() {
        Integer mentorId = null;
        var gender = GenderType.GENDER_MALE;
        User user = null;
        String firstName = "Rachid";
        String lastName = "BAAZIZ";
        String email = "rachidbaaziz.contact@gmail.com";
        String phoneNumber = "+212777458294";
        String title = "Software engineer";
        String description = "A description";
        String city = "Casablanca";
        String job = "Employee";
        String expertiseField = "Software engineering";
        double sessionPrice = 0.0;
        var mentorData = new MentorCreationDto(gender, firstName, lastName, email, phoneNumber, title, description, city, job, ExpertiseField.SCIENCES, null, null);
        //var mentorData = new MentorCreationDto();
        var expectedMentor = new Mentor(gender, email, phoneNumber, title, description, city, job, ExpertiseField.SCIENCES, sessionPrice, false, null, null);
        var mentor = mentorMapper.toMentor(mentorData);
        Assertions.assertEquals(expectedMentor, mentor);
    }

    @Test
    public void mentorToItemTest() {
        Integer mentorId = 1;
        var user = new User();
        String firstName = "Rachid";
        String lastName = "BAAZIZ";
        String email = "rachidbaaziz.contact@gmail.com";
        String phoneNumber = "+212777458294";
        String title = "Software engineer";
        String description = "A description";
        double sessionPrice = 100;
        var mentor = new Mentor(mentorId, user, firstName, lastName, email, phoneNumber, title, description, sessionPrice);
        var expectedMentorItem = new MentorItemDto(mentorId, firstName + lastName, title, sessionPrice);
        var mentorItem = mentorMapper.toMentorItem(mentor);
        Assertions.assertEquals(expectedMentorItem, mentorItem);
    }

    @Test
    public void mentorToDetailsTest() {
        Integer mentorId = 1;
        var user = new User();
        String firstName = "Rachid";
        String lastName = "BAAZIZ";
        String email = "rachidbaaziz.contact@gmail.com";
        String phoneNumber = "+212777458294";
        String title = "Software engineer";
        String description = "A description";
        double sessionPrice = 100;
        var mentor = new Mentor(mentorId, user, firstName, lastName, email, phoneNumber, title, description, sessionPrice);
        var expectedMentorDetails = new MentorDetailsDto(mentorId, firstName + lastName, email, phoneNumber, title, description, sessionPrice);
        var mentorItem = mentorMapper.toMentorDetails(mentor);
        Assertions.assertEquals(expectedMentorDetails, mentorItem);
    }
}
