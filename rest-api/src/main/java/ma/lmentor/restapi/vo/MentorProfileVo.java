package ma.lmentor.restapi.vo;

import lombok.*;
import ma.lmentor.restapi.models.GenderType;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MentorProfileVo {
    @NotNull(message = "Please choose your gender")
    private GenderType gender;
    @NotEmpty(message = "Please enter your first name")
    private String firstName;
    @NotEmpty(message = "Please enter your last name")
    private String lastName;
    @NotEmpty(message = "Please enter your email")
    @Email(message = "Please enter a valid email address")
    private String contactEmail;
    @NotEmpty(message = "Please enter your phone number")
    private String phoneNumber;
    @NotEmpty(message = "Please enter a title")
    private String title;
    private String description;
    private String linkedinUrl;
    @NotEmpty(message = "Please choose your city")
    private String city;
    @NotNull(message = "Please choose an expertise field")
    private Set<Long> expertises;
    @NotNull(message = "You should enter at least one education")
    private EducationVo lastEducation;
    @NotNull(message = "You should enter at least one experience")
    private ExperienceVo lastExperience;
}
