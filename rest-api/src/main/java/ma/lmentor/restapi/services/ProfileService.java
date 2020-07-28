package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.Profile;
import ma.lmentor.restapi.entities.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private MentorService mentorService;
    private StudentService studentService;

    public ProfileService(MentorService mentorService, StudentService studentService) {
        this.mentorService = mentorService;
        this.studentService = studentService;
    }

    public Profile createEmptyProfile(User user) {
        switch (user.getRole()) {
            case ROLE_MENTOR:
                return mentorService.createEmpty(user);
            case ROLE_STUDENT:
                return studentService.createEmpty(user);
            default: return null;
        }
    }
}
