package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Experience;
import ma.lmentor.restapi.vo.ExperienceVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    Experience toExperience(final ExperienceVo experienceVo);
}
