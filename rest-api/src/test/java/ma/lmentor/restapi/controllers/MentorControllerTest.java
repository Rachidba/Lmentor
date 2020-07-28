package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MentorControllerTest extends AbstractTest {
    @Override
    @BeforeAll
    public void setUp() {
        super.setUp();
    }

    @Test
    public void mentorCreation() throws Exception {
        var experienceCreationDto = new ExperienceCreationDto();
        experienceCreationDto.setCompanyName("Societe generale");
        experienceCreationDto.setRole("R&D Software engineer");
        experienceCreationDto.setDescription("It was cool");
        experienceCreationDto.setStartYear(2019);
        experienceCreationDto.setStartMonth(8);

        var experiences = new HashSet<ExperienceCreationDto>();
        experiences.add(experienceCreationDto);

        var educationCreationDto = new EducationCreationDto();
        educationCreationDto.setSchool("FST Mohammedia");
        educationCreationDto.setDegree("Master degree");
        educationCreationDto.setStartYear(2016);
        educationCreationDto.setEndYear(2019);
        educationCreationDto.setFieldOfStudy("Software engineering");

        var educations = new HashSet<EducationCreationDto>();
        educations.add(educationCreationDto);

        var mentorCreationDto = new MentorCreationDto();
        mentorCreationDto.setGender(GenderType.GENDER_MALE);
        //mentorCreationDto.setFirstName("Rachid");
        mentorCreationDto.setLastName("BAAZIZ");
        mentorCreationDto.setContactEmail("rachidbaaziz.contact@gmail.com");
        mentorCreationDto.setTitle("Software engineer");
        mentorCreationDto.setCity("Casablanca");
        mentorCreationDto.setJob("Employee");
        mentorCreationDto.setExpertiseField(ExpertiseField.SCIENCES);
        mentorCreationDto.setPhoneNumber("06125478");
        mentorCreationDto.setExperiences(experiences);
        mentorCreationDto.setEducations(educations);

        var url = "/api/mentors";
        var inputJson = super.mapToJson(mentorCreationDto);
        var mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        var response = mvcResult.getResponse();
        Assertions.assertEquals(400, response.getStatus());
    }
}
