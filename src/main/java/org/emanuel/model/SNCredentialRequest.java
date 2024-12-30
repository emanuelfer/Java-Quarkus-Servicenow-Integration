package org.emanuel.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
@ApplicationScoped
public class SNCredentialRequest {

    public SNCredentialRequest() {
    }
    @ConfigProperty(name = "grant.type")
    private String grant_type;

    @ConfigProperty(name = "client.id")
    private String client_id;

    @ConfigProperty(name = "client.secret")
    private String client_secret;

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }


    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

}
