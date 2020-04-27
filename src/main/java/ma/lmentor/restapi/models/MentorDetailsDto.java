package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorDetailsDto {
    private Integer profileId;
    private String fullName;
    private String title;
    private String description;
    private String email;
    private String phoneNumber;
    private double sessionPrice;
    private boolean isProfileCompleted;
    private Set<EducationDto> educations;
    private Set<ExperienceDto> experiences;

    public MentorDetailsDto(Integer profileId, String fullName, String email, String phoneNumber,
                            String title, String description, double sessionPrice) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }
}
