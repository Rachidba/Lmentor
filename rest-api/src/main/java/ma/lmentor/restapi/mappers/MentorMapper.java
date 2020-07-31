package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.vo.MentorProfileVo;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(uses = { EducationMapper.class, ExperienceMapper.class }, componentModel = "spring")
public interface MentorMapper {
    Mentor toMentor(final MentorProfileVo mentor);
    @Mapping(expression = "java(mentor.getFirstName() + ' ' + mentor.getLastName())", target = "fullName")
    MentorDetailsDto toMentorDetails(final Mentor mentor);
    @Mapping(expression = "java(mentor.getFirstName() + ' ' + mentor.getLastName())", target = "fullName")
    MentorItemDto toMentorItem(final Mentor mentor);
    List<MentorItemDto> toMentorItems(final List<Mentor> mentors);
}
