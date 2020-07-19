package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EducationCreationDto {
    @NotEmpty(message = "Please enter your school name")
    private String school;
    @NotEmpty(message = "Please enter the degree")
    private String degree;
    @NotEmpty(message = "Please enter the field of study")
    private String fieldOfStudy;
    private int startYear;
    @NotEmpty(message = "Please enter the end year")
    private int endYear;
    private String description;
}
