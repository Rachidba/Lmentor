package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.models.MentorCreationDto;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MentorMapper {
    @Mapping(expression = "java(Double.valueOf(\"0\"))", target = "sessionPrice")
    Mentor toMentor(final MentorCreationDto mentor);
    @Mapping(expression = "java(mentor.getFirstName() + ' ' + mentor.getLastName())", target = "fullName")
    MentorDetailsDto toMentorDetails(final Mentor mentor);
    @Mapping(expression = "java(mentor.getFirstName() + ' ' + mentor.getLastName())", target = "fullName")
    MentorItemDto toMentorItem(final Mentor mentor);
    List<MentorItemDto> toMentorItems(final List<Mentor> mentors);
}
