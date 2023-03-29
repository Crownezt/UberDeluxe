package africa.semicolon.uberdeluxe.notification;

        import africa.semicolon.uberdeluxe.data.dtos.request.Recipient;
        import africa.semicolon.uberdeluxe.data.dtos.request.EmailNotificationRequest;
        import africa.semicolon.uberdeluxe.notification.MailService;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        import java.util.List;

        import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SendinblueServiceImplTest {

    @Autowired
    private MailService mailService;
    private EmailNotificationRequest emailNotificationRequest;

    @BeforeEach
    void setUp() {
        List<Recipient> to = List.of(
                new Recipient("dean", "o.michaeldean@gmail.com")
        );
        emailNotificationRequest=new EmailNotificationRequest();
        emailNotificationRequest.setTo(to);
        emailNotificationRequest.setHtmlContent("Hello");
    }

    @Test
    void sendHtmlMail() {
        var response = mailService.sendHtmlMail(emailNotificationRequest);
        assertThat(response).isNotNull();
    }
}

