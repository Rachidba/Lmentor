package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationDto {
    private String username;
    private String password;
    private RoleType role;

    public RegistrationDto(String username, String password, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
