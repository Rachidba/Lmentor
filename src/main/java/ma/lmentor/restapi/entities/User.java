package ma.lmentor.restapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.lmentor.restapi.models.RoleType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled = true;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User(String username, String password, RoleType role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.role = user.role;
    }
}
