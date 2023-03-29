package africa.semicolon.uberdeluxe.data.repositories;

import africa.semicolon.uberdeluxe.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
