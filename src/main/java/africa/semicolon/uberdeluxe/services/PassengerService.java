package africa.semicolon.uberdeluxe.services;

import africa.semicolon.uberdeluxe.data.model.Passenger;
import africa.semicolon.uberdeluxe.data.dtos.request.RegisterPassengerRequest;
import africa.semicolon.uberdeluxe.data.dtos.response.RegisterResponse;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface PassengerService {
    RegisterResponse register(RegisterPassengerRequest registerRequest);
    Passenger getPassengerById(Long passengerId);

    void savePassenger(Passenger passenger);
    Optional<Passenger> getPassengerBy(Long passengerId);
    Passenger updatePassenger(Long passengerId, JsonPatch updatePayload);

    Page<Passenger> getAllPassenger(int pageNumber);

    void deletePassenger(Long id);
}
