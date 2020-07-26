package ma.lmentor.restapi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.lmentor.restapi.models.RoleType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationVo {
    @NotEmpty(message = "Email is mandatory for account creation")
    @Email(message = "Enter a valid email")
    private String email;
    @NotEmpty(message = "Password is mandatory for account creation")
    private String password;
    @NotNull(message = "Role is mandatory for account creation")
    private RoleType role;

}
