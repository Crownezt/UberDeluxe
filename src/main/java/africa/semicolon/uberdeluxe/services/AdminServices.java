package africa.semicolon.uberdeluxe.services;

import africa.semicolon.uberdeluxe.data.dtos.request.InviteAdminRequest;
import africa.semicolon.uberdeluxe.data.dtos.response.ApiResponse;

import java.util.Set;

public interface AdminServices {
    ApiResponse sendInviteRequests(Set<InviteAdminRequest> inviteAdminRequestList);
}
