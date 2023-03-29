package africa.semicolon.uberdeluxe.data.repositories;

import africa.semicolon.uberdeluxe.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
