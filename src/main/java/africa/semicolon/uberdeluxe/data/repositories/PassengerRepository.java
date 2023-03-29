package africa.semicolon.uberdeluxe.data.repositories;

import africa.semicolon.uberdeluxe.data.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
