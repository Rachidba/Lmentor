package ma.lmentor.restapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class MentorItemDto {
    private Integer id;
    private String fullName;
    private String title;
    private double sessionPrice;

    public MentorItemDto(int id, String fullName, String title, double sessionPrice) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.sessionPrice = sessionPrice;
    }
}
