package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Education;
import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.mappers.EducationMapper;
import ma.lmentor.restapi.repositories.EducationRepository;
import ma.lmentor.restapi.vo.EducationVo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    private EducationRepository educationRepository;
    private EducationMapper educationMapper;
    private UserService userService;

    public EducationService(EducationRepository educationRepository, EducationMapper educationMapper, @Lazy UserService userService) {
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
        this.userService = userService;
    }

    public Education create(final EducationVo educationVo) throws NotFoundException {
        var education = educationMapper.toEducation(educationVo);
        var currentUser = userService.getCurrentUser();
        if (currentUser.isEmpty())
            throw new NotFoundException("User not found");
        var currentMentor = currentUser.get().getProfile();
        education.setMentor((Mentor) currentMentor);
        return educationRepository.save(education);
    }
}
