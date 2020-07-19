package ma.lmentor.restapi.services;

import ma.lmentor.restapi.entities.Profile;
import ma.lmentor.restapi.entities.User;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private MentorService mentorService;

    public ProfileService(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    public Profile createEmptyProfile(User user) {
        switch (user.getRole()) {
            case ROLE_MENTOR:
                return mentorService.createEmpty(user);
            default: return null;
        }
    }

}
