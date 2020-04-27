package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExperienceDto {
    private Integer id;
    private String companyName;
    private String role;
    private int startYear;
    private int startMonth;
    private int endYear;
    private int endMonth;
    private String description;
}
