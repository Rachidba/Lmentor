package ma.lmentor.restapi.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class EducationVo {
    @NotEmpty(message = "Please enter your school name")
    private String school;
    @NotEmpty(message = "Please enter the degree")
    private String degree;
    @NotEmpty(message = "Please enter the field of study")
    private String fieldOfStudy;
    private int startYear;
    private int endYear;
    private String description;
}
