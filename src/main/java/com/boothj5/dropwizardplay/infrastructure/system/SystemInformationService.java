package com.boothj5.dropwizardplay.infrastructure.system;

import com.boothj5.dropwizardplay.core.SystemInformation;

public class SystemInformationService {

    public SystemInformation getSystemInformation() {
        String arch = System.getProperty("os.arch");
        String name = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String user = System.getProperty("user.name");

        return new SystemInformation(arch, name, version, user);
    }
}