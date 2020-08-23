package ma.lmentor.restapi.models;

import lombok.*;
import ma.lmentor.restapi.entities.Subcategory;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class MentorItemDto {
    private Integer profileId;
    private String fullName;
    private String title;
    private String description;
    private Set<Subcategory> expertiseAreas;
}
