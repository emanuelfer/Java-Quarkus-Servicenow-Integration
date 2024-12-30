package org.emanuel.restclient;

import io.quarkus.rest.client.reactive.ClientBasicAuth;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.emanuel.model.UserListResponse;
import org.emanuel.model.UserResponse;
import org.jboss.resteasy.reactive.client.api.ClientLogger;

@RegisterRestClient(configKey = "sn-api")
public interface RestClientInfoUser extends ClientLogger {

    @GET
    UserListResponse getUsers(@HeaderParam("Authorization") String customHeader);
}
