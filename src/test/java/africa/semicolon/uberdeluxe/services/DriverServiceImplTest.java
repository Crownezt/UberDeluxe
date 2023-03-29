package africa.semicolon.uberdeluxe.services;

import africa.semicolon.uberdeluxe.data.dtos.request.RegisterDriverRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DriverServiceImplTest {

    @Autowired
    private DriverService driverService;
    private RegisterDriverRequest request;
    @BeforeEach
    void setUp() {
        request=new RegisterDriverRequest();
        request.setPassword("test_password");
        request.setName("test driver");
        request.setEmail("test@email.com");
    }

    @Test
    void register() throws IOException {
        MockMultipartFile file =
                new MockMultipartFile("test_license",
                        new FileInputStream("/home/semicolon/Documents/spring-projects/uberdeluxe/src/main/resources/static/balablu.jpeg"));
        var response = driverService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.isSuccessful()).isTrue();
        assertThat(response.getCode()).isEqualTo(HttpStatus.CREATED.value());

    }
}
