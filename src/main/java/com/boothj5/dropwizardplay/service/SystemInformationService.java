package com.boothj5.dropwizardplay.service;

public class SystemInformationService {

    public String getOSArch() {
        return System.getProperty("os.arch");
    }

    public String getOSVersion() {
        return System.getProperty("os.version");
    }

    public String getOSName() {
        return System.getProperty("os.name");
    }

    public String getUser() {
        return System.getProperty("user.name");
    }
}