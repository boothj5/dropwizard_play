package com.boothj5.dropwizardplay;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class DropwizardPlayConfiguration extends Configuration {
    @NotEmpty
    private String jenkinsHost;

    @JsonProperty
    public String getJenkinsHost() {
        return jenkinsHost;
    }

    @JsonProperty
    public void setJenkinsHost(String jenkinsHost) {
        this.jenkinsHost = jenkinsHost;
    }
}
