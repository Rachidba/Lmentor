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
public class ExperienceCreationDto {
    @NotEmpty(message = "Please enter the company name")
    private String companyName;
    @NotEmpty(message = "Please enter your role in the company")
    private String role;
    private int startYear;
    private int startMonth;
    private int endYear;
    private int endMonth;
    private String description;
}
