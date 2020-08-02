package ma.lmentor.restapi.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class MentorItemDto {
    private Integer profileId;
    private String fullName;
    private String title;
    private double sessionPrice;
}
