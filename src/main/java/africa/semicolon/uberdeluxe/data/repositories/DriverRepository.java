package africa.semicolon.uberdeluxe.data.repositories;
import africa.semicolon.uberdeluxe.data.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
