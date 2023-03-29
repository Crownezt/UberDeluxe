package africa.semicolon.uberdeluxe.data.repositories;

import africa.semicolon.uberdeluxe.data.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
