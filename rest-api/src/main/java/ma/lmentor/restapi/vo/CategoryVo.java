package ma.lmentor.restapi.vo;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class CategoryVo {
    @NotNull
    @NotEmpty
    private String categoryName;

}
