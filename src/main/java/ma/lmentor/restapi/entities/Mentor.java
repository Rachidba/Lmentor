package ma.lmentor.restapi.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "mentors")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Mentor extends Profile {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String description;
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "session_price")
    private double sessionPrice;

    public Mentor(Integer profileId, String firstName, String lastName, String email, String phoneNumber,
                             String title, String description, double sessionPrice) {
        super(profileId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }
}
