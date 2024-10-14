package repository;

import model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Long> {
    Optional<Diploma> findById(UUID diplomaId);
}
