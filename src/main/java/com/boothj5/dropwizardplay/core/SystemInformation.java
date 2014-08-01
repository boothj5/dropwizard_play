package com.boothj5.dropwizardplay.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemInformation {
    private String user;
    private String os;

    public SystemInformation() {}

    public SystemInformation(String os, String user) {
        this.os = os;
        this.user = user;
    }

    @JsonProperty
    public String getOs() {
        return os;
    }

    public String getUser() {
        return user;
    }
}
