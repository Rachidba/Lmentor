package ma.lmentor.restapi.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profiles")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "profile_id")
    protected Integer profileId;
    @Column(name = "first_name")
    protected String firstName;
    @Column(name = "last_name")
    protected String lastName;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    public Profile(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getProfileId() {
        return this.profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
