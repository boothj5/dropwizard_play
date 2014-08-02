package com.boothj5.dropwizardplay.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JenkinsJobs {
    private List<JenkinsJobSummary> jobs;

    public List<JenkinsJobSummary> getJobs() {
        return jobs;
    }

    public void setJobs(List<JenkinsJobSummary> jobs) {
        this.jobs = jobs;
    }
}
