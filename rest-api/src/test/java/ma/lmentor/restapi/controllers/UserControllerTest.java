package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.models.*;
import ma.lmentor.restapi.vo.RegistrationDto;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest extends AbstractTest {

    @Override
    @BeforeAll
    public void setUp() {
        super.setUp();
    }

    @Test
    public void register_shouldReturn400_whenNonExistingFields() throws Exception {
        /*

        */

        var registerDto = new RegistrationDto();
        registerDto.setEmail("rachidba");
        registerDto.setPassword("password");

        var url = "/api/register";
        var inputJson = super.mapToJson(registerDto);
        var mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(url)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(inputJson))
                            .andReturn();

        var response = mvcResult.getResponse();
        Assertions.assertEquals(400, response.getStatus());

        var responseContent = response.getContentAsString();
        var errors = super.mapFromJson(responseContent, HashMap.class);
        Assertions.assertEquals(2, errors.size());
        Assertions.assertTrue(errors.containsKey("username"));
        Assertions.assertTrue(errors.containsKey("role"));
    }

    @Test
    public void register_shouldReturn400_whenInvalidEmail() throws Exception {
        var registerDto = new RegistrationDto();
        registerDto.setEmail("rachidba");
        registerDto.setPassword("password");
        registerDto.setRole(RoleType.ROLE_MENTOR);

        var url = "/api/register";
        var inputJson = super.mapToJson(registerDto);
        var mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        var response = mvcResult.getResponse();
        Assertions.assertEquals(400, response.getStatus());

        var responseContent = response.getContentAsString();
        var errors = super.mapFromJson(responseContent, HashMap.class);
        Assertions.assertEquals(1, errors.size());
        Assertions.assertTrue(errors.containsKey("username"));
    }

    @Test
    public void register_shouldReturn200_whenValidEmail() throws Exception {
        var registerDto = new RegistrationDto();
        registerDto.setEmail("rachidba@gmail.com");
        registerDto.setPassword("password");
        registerDto.setRole(RoleType.ROLE_MENTOR);

        var url = "/api/register";
        var inputJson = super.mapToJson(registerDto);
        var mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        var response = mvcResult.getResponse();
        Assertions.assertEquals(200, response.getStatus());
    }
}
