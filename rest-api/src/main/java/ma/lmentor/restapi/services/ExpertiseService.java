package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Experience;
import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.mappers.ExperienceMapper;
import ma.lmentor.restapi.repositories.ExperienceRepository;
import ma.lmentor.restapi.vo.ExperienceVo;
import org.springframework.stereotype.Service;

@Service
public class ExpertiseService {
    private ExperienceRepository experienceRepository;
    private ExperienceMapper experienceMapper;
    private UserService userService;

    public ExpertiseService(ExperienceRepository experienceRepository, ExperienceMapper experienceMapper, UserService userService) {
        this.experienceRepository = experienceRepository;
        this.experienceMapper = experienceMapper;
        this.userService = userService;
    }

    public Experience create(final ExperienceVo experienceVo) throws NotFoundException {
        var experience = experienceMapper.toExperience(experienceVo);
        var currentUser = userService.getCurrentUser();
        if (currentUser.isEmpty())
            throw new NotFoundException("User not found");
        var currentMentor = currentUser.get().getProfile();
        experience.setMentor((Mentor) currentMentor);
        return experienceRepository.save(experience);
    }
}
