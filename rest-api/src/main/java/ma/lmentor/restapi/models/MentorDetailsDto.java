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
    private String phoneNumber;
    private double sessionPrice;
    private boolean isProfileCompleted;
    private Set<EducationDto> educations;
    private Set<ExperienceDto> experiences;

    public MentorDetailsDto(Integer profileId, String fullName, String phoneNumber,
                            String title, String description, double sessionPrice) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }
}
