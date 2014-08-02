package com.boothj5.dropwizardplay.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsJobs {
    private List<JenkinsJob> jobs;

    public List<JenkinsJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<JenkinsJob> jobs) {
        this.jobs = jobs;
    }
}
