package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorCreationDto {
    private GenderType gender;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;
    private String description;
    private String city;
    private String job;
    private String expertiseField;
    // Add birthday
    private Set<EducationCreationDto> educations;
    private Set<ExperienceCreationDto> experiences;
}
