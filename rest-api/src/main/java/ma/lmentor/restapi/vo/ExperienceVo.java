package ma.lmentor.restapi.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ExperienceVo {
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
