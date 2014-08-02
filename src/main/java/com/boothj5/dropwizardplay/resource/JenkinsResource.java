package com.boothj5.dropwizardplay.resource;

import com.boothj5.dropwizardplay.core.JenkinsJobs;
import com.boothj5.dropwizardplay.infrastructure.externalsystem.JenkinsClient;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jenkins")
public class JenkinsResource {

    private final JenkinsClient client;

    public JenkinsResource(JenkinsClient client) {
        this.client = client;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public JenkinsJobs getSummary() {
        return client.getJobs();
    }
}
