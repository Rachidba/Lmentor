package ma.lmentor.restapi.controllers;

import ma.lmentor.restapi.models.MentorCreationDto;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.services.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MentorDetailsDto> createMentor(@RequestBody MentorCreationDto mentorData) {
        var saveResult = mentorService.Create(mentorData);
        if (saveResult.isEmpty()) return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveResult.get());
    }
}
