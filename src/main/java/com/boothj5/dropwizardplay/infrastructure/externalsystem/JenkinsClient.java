package com.boothj5.dropwizardplay.infrastructure.externalsystem;

import com.boothj5.dropwizardplay.core.JenkinsJobs;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class JenkinsClient {

    private final String host;

    public JenkinsClient(String jenkinsHost) {
        this.host = jenkinsHost;
    }

    public JenkinsJobs getJobs() {
        Client client = Client.create();
        WebResource resource = client.resource(host + "/api/json");
        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Jenkins Down!");
        } else {
            return response.getEntity(JenkinsJobs.class);
        }
    }
}