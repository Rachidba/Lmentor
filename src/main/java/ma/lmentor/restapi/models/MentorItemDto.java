package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorItemDto {
    private Integer profileId;
    private String fullName;
    private String title;
    private double sessionPrice;

    public MentorItemDto(int profileId, String fullName, String title, double sessionPrice) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.title = title;
        this.sessionPrice = sessionPrice;
    }
}
