package ma.lmentor.restapi.services;

import javassist.NotFoundException;
import ma.lmentor.restapi.entities.Mentor;
import ma.lmentor.restapi.entities.User;
import ma.lmentor.restapi.mappers.MentorMapper;
import ma.lmentor.restapi.models.MentorCreationDto;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.repositories.MentorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    private MentorRepository mentorRepository;
    private MentorMapper mentorMapper;
    private UserService userService;

    public MentorService(MentorRepository mentorRepository, MentorMapper mentorMapper, @Lazy UserService userService) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
        this.userService = userService;
    }

    public Optional<MentorDetailsDto> Create(MentorCreationDto mentorData) throws NotFoundException {
        var mentor = mentorMapper.toMentor(mentorData);
        var currentUser = userService.getCurrentUser();
        //TODO update exception
        if (currentUser.isEmpty()) throw new NotFoundException("User not found!");
        mentor.setUser(currentUser.get());
        mentor.setProfileId(currentUser.get().getProfile().getProfileId());
        mentor.setProfileCompleted(true);
        var savedMentor = mentorRepository.save(mentor);
        return savedMentor == null ? Optional.empty() : Optional.of(mentorMapper.toMentorDetails(savedMentor));
    }

    public Mentor createEmpty(User user) {
        return mentorRepository.save(new Mentor(user));
    }

    public List<MentorItemDto> GetAllMentors() {
        var mentors = mentorRepository.findAll();
        return mentorMapper.toMentorItems(mentors);
    }

    public Optional<MentorDetailsDto> GetMentor(Integer mentorId) {
        var mentor = mentorRepository.findById(mentorId);
        return mentor.isPresent() ? Optional.of(mentorMapper.toMentorDetails(mentor.get())) : Optional.empty();
    }
}
