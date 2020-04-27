package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegistrationDto {
    @NotNull(message = "Email is mandatory for account creation")
    private String username;
    @NotNull(message = "Password is mandatory for account creation")
    private String password;
    @NotNull(message = "Role is mandatory for account creation")
    private RoleType role;

    public RegistrationDto(String username, String password, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
