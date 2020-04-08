package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorDetailsDto {
    private Integer id;
    private String fullName;
    private String title;
    private String description;
    private String email;
    private String phoneNumber;
    private double sessionPrice;

    public MentorDetailsDto(Integer id, String fullName, String email, String phoneNumber,
                            String title, String description, double sessionPrice) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.description = description;
        this.sessionPrice = sessionPrice;
    }
}
