package africa.semicolon.uberdeluxe.services;

import africa.semicolon.uberdeluxe.data.dtos.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AppUserService {

    ApiResponse uploadProfileImage(MultipartFile profileImage, Long userId);

    ApiResponse verifyAccount(Long userId, String token);
}