package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Category;
import ma.lmentor.restapi.vo.CategoryVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(final CategoryVo categoryVo);
}
