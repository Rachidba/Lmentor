package ma.lmentor.restapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MentorLoginResponse extends LoginResponse {
    private boolean isProfileCompleted;

    public MentorLoginResponse(Integer profileId,
                               String fullName,
                               String jwToken,
                               String email,
                               RoleType role,
                               boolean isProfileCompleted) {
        super(profileId, fullName, jwToken, email, role, isProfileCompleted);
    }
}
