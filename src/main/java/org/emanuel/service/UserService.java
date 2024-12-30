package org.emanuel.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.emanuel.model.SNCredential;
import org.emanuel.model.SNCredentialRequest;
import org.emanuel.model.UserListResponse;
import org.emanuel.model.UserResponse;
import org.emanuel.restclient.RestClientCredentials;
import org.emanuel.restclient.RestClientInfoUser;
//import org.emanuel.restclient.RestClientInfoUser;

@RequestScoped
public class UserService {

    @Inject
    private SNCredentialRequest snCredentialRequest;

    @ConfigProperty(name = "grant.type")
    String grantType;

    @ConfigProperty(name = "client.id")
    String clientId;

    @ConfigProperty(name = "client.secret")
    String clientSecret;

    @ConfigProperty(name = "jwt.iss")
    private String iss;

    @ConfigProperty(name = "jwt.sub")
    private String sub;

    @ConfigProperty(name = "jwt.kid")
    private String kid;

    @Inject
    @RestClient
    private RestClientInfoUser restClientInfoUser;

    @Inject
    @RestClient
    private RestClientCredentials restClientCredentials;


    public UserListResponse getUsers(){

        Log.info("#### Client ID ##### " + clientId);

        SNCredential snCredential = restClientCredentials.getAccessToken(grantType, clientId, clientSecret,
                JwtUtils.generateToken(iss, sub, iss, kid));
        String customHeader = "Bearer "+ snCredential.access_token();
        return restClientInfoUser.getUsers(customHeader);
    }

//    public SNCredential getAccessToken(){
//        SNCredentialRequest snCredentialRequest = new SNCredentialRequest();
//        return restClientCredentials.getAccessToken(snCredentialRequest.getGrant_type(),
//                snCredentialRequest.getClient_id(),
//                snCredentialRequest.getClient_secret(),
//                snCredentialRequest.getAssertion());
//    }

}
