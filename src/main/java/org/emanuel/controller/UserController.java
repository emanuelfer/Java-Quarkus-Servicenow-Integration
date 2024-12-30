package org.emanuel.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.emanuel.model.SNCredential;
import org.emanuel.model.SNCredentialRequest;
import org.emanuel.model.UserListResponse;
import org.emanuel.model.UserResponse;
import org.emanuel.service.JwtUtils;
import org.emanuel.service.UserService;

@Path("/users")
@RequiredArgsConstructor
public class UserController {

    @Inject
    private final UserService userService;


    @GET
    public UserListResponse getUsers(){
        return userService.getUsers();
    }

//    @GET
//    @Path("/token")
//    public String getAccessToken() throws Exception {
//        return JwtUtils.generateToken();
//    }
}
