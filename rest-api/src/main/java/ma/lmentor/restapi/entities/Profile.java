package ma.lmentor.restapi.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@SuperBuilder
@Table(name = "profiles")
@EqualsAndHashCode
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
    @Column(name = "phone_number")
    protected String phoneNumber;
    @Column(name = "is_profile_completed")
    protected boolean isProfileCompleted = false;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    public Profile(User user) {
        this.user = user;
    }
    public Integer getProfileId() {
        return this.profileId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isProfileCompleted() {
        return isProfileCompleted;
    }
}
