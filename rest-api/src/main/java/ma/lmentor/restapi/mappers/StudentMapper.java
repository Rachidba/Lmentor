package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.Student;
import ma.lmentor.restapi.vo.StudentProfileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentProfileVo studentProfileVo);
}
