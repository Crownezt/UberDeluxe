package africa.semicolon.uberdeluxe.mapper;

import africa.semicolon.uberdeluxe.data.model.AppUser;
import africa.semicolon.uberdeluxe.data.dtos.request.RegisterPassengerRequest;
import africa.semicolon.uberdeluxe.data.repositories.AppUserRepository;

public class ParaMapper {

    public static AppUser map(RegisterPassengerRequest request) {
        AppUser appUser = new AppUser();

        appUser.setEmail(request.getEmail());
        appUser.setPassword(request.getPassword());
        appUser.setName(request.getName());
        return appUser;
    }
}
