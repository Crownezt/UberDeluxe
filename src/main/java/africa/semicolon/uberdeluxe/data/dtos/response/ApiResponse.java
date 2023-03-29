package africa.semicolon.uberdeluxe.data.dtos.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ApiResponse {
    private int status;
    private String message;
}
