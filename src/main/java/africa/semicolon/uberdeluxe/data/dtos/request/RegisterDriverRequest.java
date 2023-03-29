package africa.semicolon.uberdeluxe.data.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterDriverRequest {
    @NotNull
    @NotEmpty
    @Size()
    private String name;
    private String email;
    private String password;
    private MultipartFile licenseImage;
}
