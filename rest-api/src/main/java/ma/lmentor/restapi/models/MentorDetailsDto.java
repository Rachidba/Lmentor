package ma.lmentor.restapi.models;

import lombok.*;
import ma.lmentor.restapi.entities.Subcategory;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class MentorDetailsDto {
    private Integer profileId;
    private String fullName;
    private String title;
    private String description;
    private String city;
    private boolean isProfileCompleted;
    private Set<Subcategory> expertiseAreas;
    private Set<EducationDto> educations;
    private Set<ExperienceDto> experiences;
}
