package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginResponse {
    private Integer profileId;
    private String fullName;
    private String jwToken;
    private String email;
    private RoleType role;
    private boolean isProfileCompleted;
}
