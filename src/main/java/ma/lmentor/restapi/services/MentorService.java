package ma.lmentor.restapi.services;

import ma.lmentor.restapi.mappers.MentorMapper;
import ma.lmentor.restapi.models.MentorCreationDto;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.repositories.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    private MentorRepository mentorRepository;
    private MentorMapper mentorMapper;

    public MentorService(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }

    public Optional<MentorDetailsDto> Create(MentorCreationDto mentorData) {
        var mentor = mentorMapper.toMentor(mentorData);
        var savedMentor = mentorRepository.save(mentor);
        return savedMentor == null ? Optional.empty() : Optional.of(mentorMapper.toMentorDetails(savedMentor));
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
