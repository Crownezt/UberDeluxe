package africa.semicolon.uberdeluxe.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import africa.semicolon.uberdeluxe.data.dtos.request.InviteAdminRequest;


@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminServices adminServices;
    private Set<InviteAdminRequest> inviteAdminRequests;
    @BeforeEach
    void setUp() {
        inviteAdminRequests=Set.of(
                new InviteAdminRequest("test@email.com", "test_name")
        );
    }

    @Test
    void sendInviteRequestsTest() {
        var response = adminServices.sendInviteRequests(inviteAdminRequests);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}