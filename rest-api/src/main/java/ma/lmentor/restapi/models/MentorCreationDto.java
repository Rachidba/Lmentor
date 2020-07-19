package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorCreationDto {
    @NotNull(message = "Please choose your gender")
    private GenderType gender;
    @NotEmpty(message = "Please enter your first name")
    private String firstName;
    @NotEmpty(message = "Please enter your last name")
    private String lastName;
    @NotEmpty(message = "Please enter your email")
    @Email(message = "Please enter a valid email address")
    private String email;
    @NotEmpty(message = "Please enter your phone number")
    private String phoneNumber;
    @NotEmpty(message = "Please enter a title")
    private String title;
    private String description;
    @NotEmpty(message = "Please choose your city")
    private String city;
    @NotEmpty(message = "Please choose your job")
    private String job;
    @NotEmpty(message = "Please choose an expertise field")
    private ExpertiseField expertiseField;
    // Add birthday
    @Size(min = 1, message = "You should enter at least one education")
    private Set<EducationCreationDto> educations;
    private Set<ExperienceCreationDto> experiences;
}
