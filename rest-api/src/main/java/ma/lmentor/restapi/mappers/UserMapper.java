package ma.lmentor.restapi.mappers;

import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.vo.RegistrationVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(final RegistrationVo registrationVo);

}
