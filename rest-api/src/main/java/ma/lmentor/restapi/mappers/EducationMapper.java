package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Education;
import ma.lmentor.restapi.vo.EducationVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    Education toEducation(final EducationVo educationVo);
}
