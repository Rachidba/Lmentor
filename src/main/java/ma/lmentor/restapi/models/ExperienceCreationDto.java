package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExperienceCreationDto {
    private String companyName;
    private String role;
    private int startYear;
    private int startMonth;
    private int endYear;
    private int endMonth;
    private String description;
}
