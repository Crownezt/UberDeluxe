package africa.semicolon.uberdeluxe.services;


import africa.semicolon.uberdeluxe.data.dtos.request.RegisterDriverRequest;
import africa.semicolon.uberdeluxe.data.dtos.response.RegisterResponse;
import africa.semicolon.uberdeluxe.data.model.Driver;

import java.util.Optional;

public interface DriverService {
    RegisterResponse register(RegisterDriverRequest request);
    Optional<Driver> getDriverBy(Long driverId);
    void saveDriver(Driver driver);
}
