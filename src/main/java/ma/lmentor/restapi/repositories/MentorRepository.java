package ma.lmentor.restapi.repositories;

import ma.lmentor.restapi.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
