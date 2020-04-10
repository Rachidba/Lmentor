package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorCreationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String title;
    private String description;
    private double sessionPrice;

    public MentorCreationDto(String firstName, String lastName, String email, String phoneNumber,
                             String title, String description, double sessionPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }
}
