package ma.lmentor.restapi.models;

import java.util.Set;

public class MentorProfileDto extends ProfileDto {
    private String title;
    private String description;
    private String email;
    private String phoneNumber;
    private Set<EducationDto> educations;
    private Set<ExperienceDto> experiences;
}
