package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.mappers.MentorMapper;
import ma.lmentor.restapi.vo.MentorProfileVo;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.repositories.MentorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorService {
    private MentorRepository mentorRepository;
    private MentorMapper mentorMapper;
    private UserService userService;
    private SubcategoryService subcategoryService;
    private ExpertiseService expertiseService;
    private EducationService educationService;

    public MentorService(MentorRepository mentorRepository,
                         MentorMapper mentorMapper,
                         @Lazy UserService userService,
                         SubcategoryService subcategoryService,
                         ExpertiseService expertiseService,
                         EducationService educationService) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
        this.userService = userService;
        this.subcategoryService = subcategoryService;
        this.expertiseService = expertiseService;
        this.educationService = educationService;
    }

    public Optional<MentorDetailsDto> create(MentorProfileVo mentorProfileVo) throws NotFoundException {
        var mentor = mentorMapper.toMentor(mentorProfileVo);
        var currentUser = userService.getCurrentUser();
        if (currentUser.isEmpty()) throw new NotFoundException("User not found!");
        mentor.setUser(currentUser.get());
        mentor.setProfileId(currentUser.get().getProfile().getProfileId());
        mentor.setProfileCompleted(true);
        var subcategories = subcategoryService.getSubcategories(mentorProfileVo.getExpertises());
        mentor.setExpertiseAreas(subcategories);
        var education = educationService.create(mentorProfileVo.getLastEducation());
        var experience = expertiseService.create(mentorProfileVo.getLastExperience());
        var savedMentor = mentorRepository.save(mentor);
        return savedMentor == null ? Optional.empty() : Optional.of(mentorMapper.toMentorDetails(savedMentor));
    }

    public Mentor createEmpty(User user) {
        return mentorRepository.save(new Mentor(user));
    }

    public List<MentorItemDto> getCompletedMentorProfiles() {
        var mentors = mentorRepository.findAll()
                .stream()
                .filter(mentor -> mentor.isProfileCompleted())
                .collect(Collectors.toList());
        return mentorMapper.toMentorItems(mentors);
    }

    public Optional<MentorDetailsDto> getMentor(Integer mentorId) {
        var mentor = mentorRepository.findById(mentorId);
        return mentor.isPresent() ? Optional.of(mentorMapper.toMentorDetails(mentor.get())) : Optional.empty();
    }
}
