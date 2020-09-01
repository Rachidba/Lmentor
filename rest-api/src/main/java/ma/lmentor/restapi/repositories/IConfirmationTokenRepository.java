package ma.lmentor.restapi.repositories;

import ma.lmentor.restapi.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
