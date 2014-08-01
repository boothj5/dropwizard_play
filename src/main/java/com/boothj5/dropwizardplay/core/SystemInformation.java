package com.boothj5.dropwizardplay.core;

public class SystemInformation {
    private String osVersion;
    private String osArch;
    private String user;
    private String osName;

    public SystemInformation(String osArch, String osName, String osVersion, String user) {
        this.osArch = osArch;
        this.osName = osName;
        this.osVersion = osVersion;
        this.user = user;
    }

    public String getOsName() {
        return osName;
    }

    public String getUser() {
        return user;
    }

    public String getOsArch() {
        return osArch;
    }

    public String getOsVersion() {
        return osVersion;
    }
}
