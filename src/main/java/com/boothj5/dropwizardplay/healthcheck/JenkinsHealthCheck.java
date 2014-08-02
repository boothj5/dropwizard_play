package com.boothj5.dropwizardplay.healthcheck;

import com.boothj5.dropwizardplay.infrastructure.externalsystem.JenkinsClient;
import com.codahale.metrics.health.HealthCheck;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class JenkinsHealthCheck extends HealthCheck {
    private final String jenkinsHost;

    public JenkinsHealthCheck(String jenkinsHost) {
        this.jenkinsHost = jenkinsHost;
    }

    @Override
    protected Result check() throws Exception {
        Client client = Client.create();
        WebResource resource = client.resource(jenkinsHost + JenkinsClient.JOBS_PATH);
        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            return Result.unhealthy("Jenkins down.");
        } else {
            return Result.healthy();
        }
    }
}
