package com.boothj5.dropwizardplay.service;

public class SystemInformationService {

    public String getOperatingSystem() {
        return System.getProperty("os.name");
    }

    public String getUser() {
        return System.getProperty("user.name");
    }
}
