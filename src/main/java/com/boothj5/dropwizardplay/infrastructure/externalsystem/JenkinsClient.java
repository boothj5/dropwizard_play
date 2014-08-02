package com.boothj5.dropwizardplay.infrastructure.externalsystem;

import com.boothj5.dropwizardplay.core.JenkinsJobs;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

import static com.codahale.metrics.MetricRegistry.name;

public class JenkinsClient {
    public static final String JOBS_PATH = "/api/json";
    private final String host;
    private final Timer callOuts;

    public JenkinsClient(MetricRegistry metrics, String jenkinsHost) {
        this.host = jenkinsHost;
        this.callOuts = metrics.timer(name(JenkinsClient.class, "call-outs"));
    }

    public JenkinsJobs getJobs() {
        Client client = Client.create();
        WebResource resource = client.resource(host + JOBS_PATH);

        Timer.Context context = callOuts.time();
        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        context.stop();

        if (response.getStatus() != 200) {
                throw new RuntimeException("Jenkins Down!");
        } else {
            return response.getEntity(JenkinsJobs.class);
        }
    }
}