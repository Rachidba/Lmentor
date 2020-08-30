package ma.lmentor.restapi.models;

import lombok.*;

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
    private boolean isProfileCompleted;
    private Set<EducationDto> educations;
    private Set<ExperienceDto> experiences;

    public MentorDetailsDto(Integer profileId,
                            String fullName,
                            String title,
                            String description) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.title = title;
        this.description = description;
    }
}
