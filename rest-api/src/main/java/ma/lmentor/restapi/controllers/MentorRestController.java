package ma.lmentor.restapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import ma.lmentor.restapi.vo.MentorProfileVo;
import ma.lmentor.restapi.models.MentorDetailsDto;
import ma.lmentor.restapi.models.MentorItemDto;
import ma.lmentor.restapi.services.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.*;

@RestController
@RequestMapping("api/mentors")
@Api(tags = "Mentor profile API")
public class MentorRestController {
    private final MentorService mentorService;

    public MentorRestController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    @ApiOperation(value = "Get all mentors")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "List of mentors returned"),
            @ApiResponse(code = SC_NO_CONTENT, message = "Mentors list is empty")
    })
    public ResponseEntity<List<MentorItemDto>> getAllMentors() {
        var mentors = mentorService.getCompletedMentorProfiles();
        var httpStatus = mentors.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(mentors);
    }

    @GetMapping("/{mentorId}")
    @ApiOperation(value = "Get mentor profile by id")
    @ApiResponses(value = {
            @ApiResponse(code = SC_FOUND, message = "Mentor returned"),
            @ApiResponse(code = SC_OK, message = "Mentor not found")
    })
    public ResponseEntity<MentorDetailsDto> getMentor(@PathVariable Integer mentorId) {
        var mentor = mentorService.getMentor(mentorId);
        if (mentor.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(mentor.get());
    }

    @PostMapping
    @ApiOperation(value = "Update mentor profile")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Profile updated"),
            @ApiResponse(code = SC_UNAUTHORIZED, message = "User not authorised to do this operation")
    })
    public ResponseEntity<MentorDetailsDto> createMentor(@Valid @RequestBody MentorProfileVo mentorData) {
        Optional<MentorDetailsDto> saveResult = null;
        try {
            saveResult = this.mentorService.create(mentorData);
            if (saveResult.isEmpty()) return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveResult.get());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }
}
