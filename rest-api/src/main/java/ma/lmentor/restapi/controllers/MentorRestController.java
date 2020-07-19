package ma.lmentor.restapi.controllers;

import javassist.NotFoundException;
import ma.lmentor.restapi.models.MentorCreationDto;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.services.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mentors")
public class MentorRestController {
    private final MentorService mentorService;

    public MentorRestController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public ResponseEntity<List<MentorItemDto>> getAllMentors() {
        var mentors = mentorService.GetAllMentors();
        var httpStatus = mentors.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.ACCEPTED;
        return ResponseEntity.status(httpStatus).body(mentors);
    }

    @GetMapping("/{mentorId}")
    public ResponseEntity<MentorDetailsDto> getMentor(@PathVariable Integer mentorId) {
        var mentor = mentorService.GetMentor(mentorId);
        if (mentor.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.FOUND).body(mentor.get());
    }

    @PostMapping
    public ResponseEntity<MentorDetailsDto> createMentor(@Valid @RequestBody MentorCreationDto mentorData) {
        Optional<MentorDetailsDto> saveResult = null;
        try {
            saveResult = this.mentorService.Create(mentorData);
            if (saveResult.isEmpty()) return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveResult.get());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }
}
