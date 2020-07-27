package ma.lmentor.restapi.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class SubcategoryVo {
    @NotNull
    @NotEmpty
    private String subcategoryName;
    private Long categoryId;
}
