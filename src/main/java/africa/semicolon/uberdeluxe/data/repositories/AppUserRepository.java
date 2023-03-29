package africa.semicolon.uberdeluxe.data.repositories;

import africa.semicolon.uberdeluxe.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
