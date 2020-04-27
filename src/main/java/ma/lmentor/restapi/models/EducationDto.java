package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EducationDto {
    private Integer id;
    private String school;
    private String degree;
    private String fieldOfStudy;
    private int startYear;
    private int endYear;
    private String description;
}
