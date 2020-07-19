package ma.lmentor.restapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.lmentor.restapi.models.ExpertiseField;
import ma.lmentor.restapi.models.GenderType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mentors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Mentor extends Profile {
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String title;
    private String description;
    private String city;
    private String job;
    @Column(name = "expertise_field")
    private ExpertiseField expertiseField;
    @Column(name = "session_price")
    private double sessionPrice;
    @Column(name = "is_profile_completed")
    private boolean isProfileCompleted;
    @OneToMany(mappedBy = "mentor", fetch = FetchType.EAGER)
    private Set<Education> educations;
    @OneToMany(mappedBy = "mentor", fetch = FetchType.EAGER)
    private Set<Experience> experiences;
    // Add birthday

    // TODO Remove this
    public Mentor(Integer profileId, User user, String firstName, String lastName, String email, String phoneNumber,
                             String title, String description, double sessionPrice) {
        super(profileId, firstName, lastName, user);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }

    public Mentor(User user) {
        super(user);
    }

    public Integer getProfileId() {
        return profileId;
    }
}
