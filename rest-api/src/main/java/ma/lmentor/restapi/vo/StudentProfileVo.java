package ma.lmentor.restapi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentProfileVo {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private String phoneNumber;
    @NotEmpty
    @Email
    private String contactEmail;
    private Set<Long> interests;
}
