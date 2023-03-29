package africa.semicolon.uberdeluxe.controllers;

import africa.semicolon.uberdeluxe.data.dtos.response.ApiResponse;
import africa.semicolon.uberdeluxe.data.dtos.request.RegisterPassengerRequest;
import africa.semicolon.uberdeluxe.data.dtos.response.RegisterResponse;
import africa.semicolon.uberdeluxe.services.PassengerService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {

    private final PassengerService passengerService;


    @PostMapping
    ResponseEntity<?> register(@RequestBody RegisterPassengerRequest registerPassengerRequest){
        RegisterResponse registerResponse = passengerService.register((registerPassengerRequest));
        return ResponseEntity.status(registerResponse.getCode()).body(registerResponse);
    }

    @GetMapping("{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long passengerId) {
        var foundPassenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.status(HttpStatus.OK).body(foundPassenger);
    }

    @GetMapping("/all/{pageNumber}")
    public ResponseEntity<?> getPassengerById(@PathVariable int pageNumber) {
        var foundPassenger = passengerService.getAllPassenger(pageNumber);
        return ResponseEntity.ok(foundPassenger.getContent());
    }

    @PatchMapping(value = "{passengerId}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updatePassenger(@PathVariable Long passengerId, @RequestBody JsonPatch updatePatch) {
        try {
            var response = passengerService.updatePassenger(passengerId, updatePatch);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok(ApiResponse.builder().message("Passenger deleted successfully"));
    }

}
