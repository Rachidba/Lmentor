package ma.lmentor.restapi.repositories;

import ma.lmentor.restapi.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    boolean existsBySubcategoryName(String subcategoryName);
    Optional<Subcategory> findBySubcategoryName(String subcategoryName);
}
