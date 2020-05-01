package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegistrationDto {
    @NotEmpty(message = "Email is mandatory for account creation")
    @Email(message = "Enter a valid email")
    private String username;
    @NotEmpty(message = "Password is mandatory for account creation")
    private String password;
    @NotNull(message = "Role is mandatory for account creation")
    private RoleType role;

    public RegistrationDto(String username, String password, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
