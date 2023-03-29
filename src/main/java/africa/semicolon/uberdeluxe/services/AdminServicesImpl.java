package africa.semicolon.uberdeluxe.services;

import africa.semicolon.uberdeluxe.data.dtos.request.EmailNotificationRequest;
import africa.semicolon.uberdeluxe.data.dtos.request.InviteAdminRequest;
import africa.semicolon.uberdeluxe.data.dtos.request.Recipient;
import africa.semicolon.uberdeluxe.data.dtos.response.ApiResponse;
import africa.semicolon.uberdeluxe.data.model.Admin;
import africa.semicolon.uberdeluxe.data.repositories.AdminRepository;
import africa.semicolon.uberdeluxe.notification.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

import africa.semicolon.uberdeluxe.exception.BusinessLogicException;
import africa.semicolon.uberdeluxe.util.AppUtilities;
import org.springframework.http.*;

@Service
@AllArgsConstructor

public class AdminServicesImpl implements AdminServices {
    private final AdminRepository adminRepository;
    private final MailService mailService;
    @Override
    public ApiResponse sendInviteRequests(Set<InviteAdminRequest> inviteAdminRequestList) {
        EmailNotificationRequest request = new EmailNotificationRequest();
        var recipients = inviteAdminRequestList.stream()
                .map(inviteAdminRequest -> createAdminProfile(inviteAdminRequest))
                .map(inviteAdminRequest -> new Recipient(inviteAdminRequest.getUserDetails().getName(), inviteAdminRequest.getUserDetails().getEmail()))
                .toList();
        request.getTo().addAll(recipients);

        String adminMail = AppUtilities.getAdminMailTemplate();
        request.setHtmlContent(String.format(adminMail, "admin", AppUtilities.generateVerificationLink(0L)));
        var response = mailService.sendHtmlMail(request);
        if (response!=null) return ApiResponse.builder().message("invite requests sent").status(HttpStatus.OK.value()).build();
        throw new BusinessLogicException("invite requests sending failed");
    }

    private Admin createAdminProfile(InviteAdminRequest inviteAdminRequest) {
        Admin admin = new Admin();
        admin.getUserDetails().setName(inviteAdminRequest.getName());
        admin.getUserDetails().setEmail(inviteAdminRequest.getEmail());
        adminRepository.save(admin);
        return admin;
    }
}
