package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.models.*;
import ma.lmentor.restapi.vo.MentorProfileVo;
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
        double sessionPrice = 0.0;
        var mentorData = MentorProfileVo.builder()
                .gender(gender)
                .firstName(firstName)
                .lastName(lastName)
                .contactEmail(email)
                .phoneNumber(phoneNumber)
                .title(title)
                .description(description)
                .city(city)
                .build();

        var expectedMentor = Mentor.builder()
                .gender(gender)
                .contactEmail(email)
                .phoneNumber(phoneNumber)
                .title(title)
                .description(description)
                .city(city)
                .sessionPrice(sessionPrice)
                .build();
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
        var mentor = Mentor.builder()
                .profileId(mentorId)
                .user(user)
                .firstName(firstName)
                .lastName(lastName)
                .contactEmail(email)
                .phoneNumber(phoneNumber)
                .title(title)
                .description(description)
                .sessionPrice(sessionPrice)
                .build();
        var expectedMentorItem = MentorItemDto.builder()
                .profileId(mentorId)
                .fullName(firstName + ' ' + lastName)
                .title(title)
                .build();
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
        var expectedMentorDetails = new MentorDetailsDto(mentorId, firstName + ' ' + lastName, email, phoneNumber, title, description, sessionPrice);
        var mentorItem = mentorMapper.toMentorDetails(mentor);
        Assertions.assertEquals(expectedMentorDetails, mentorItem);
    }
}
