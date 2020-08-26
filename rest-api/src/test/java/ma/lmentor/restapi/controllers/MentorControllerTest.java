package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.models.*;
import ma.lmentor.restapi.vo.EducationVo;
import ma.lmentor.restapi.vo.ExperienceVo;
import ma.lmentor.restapi.vo.MentorProfileVo;
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
        var experienceVo = new ExperienceVo();
        experienceVo.setCompanyName("Societe generale");
        experienceVo.setRole("R&D Software engineer");
        experienceVo.setDescription("It was cool");
        experienceVo.setStartYear(2019);
        experienceVo.setStartMonth(8);

        var educationVo = new EducationVo();
        educationVo.setSchool("FST Mohammedia");
        educationVo.setDegree("Master degree");
        educationVo.setStartYear(2016);
        educationVo.setEndYear(2019);
        educationVo.setFieldOfStudy("Software engineering");

        var educations = new HashSet<EducationVo>();
        educations.add(educationVo);

        var mentorCreationDto = new MentorProfileVo();
        mentorCreationDto.setGender(GenderType.GENDER_MALE);
        mentorCreationDto.setFirstName("Rachid");
        mentorCreationDto.setLastName("BAAZIZ");
        mentorCreationDto.setTitle("Software engineer");
        mentorCreationDto.setCity("Casablanca");
        mentorCreationDto.setPhoneNumber("06125478");
        mentorCreationDto.setLastEducation(educationVo);
        mentorCreationDto.setLastExperience(experienceVo);

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
