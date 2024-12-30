package org.emanuel.restclient;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.emanuel.model.SNCredential;
import org.emanuel.model.SNCredentialRequest;
import org.jboss.resteasy.reactive.client.api.ClientLogger;

@RegisterRestClient(configKey = "sn-credential")
public interface RestClientCredentials extends ClientLogger {


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    SNCredential getAccessToken(@FormParam("grant_type") String grant_type,
                                @FormParam("client_id") String client_id,
                                @FormParam("client_secret") String client_secret,
                                @FormParam("assertion") String assertion);
}
