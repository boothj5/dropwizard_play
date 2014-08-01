package com.boothj5.dropwizardplay.resources;

import com.boothj5.dropwizardplay.core.SystemInformation;
import com.boothj5.dropwizardplay.service.SystemInformationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sysinfo")
@Produces(MediaType.APPLICATION_JSON)
public class SysInfoResource {

    private final SystemInformationService service;

    public SysInfoResource(SystemInformationService service) {
        this.service = service;
    }

    @GET
    public SystemInformation systemInfo() {
        String osArch = service.getOSArch();
        String osName = service.getOSName();
        String osVersion = service.getOSVersion();
        String user = service.getUser();

        return new SystemInformation(osArch, osName, osVersion, user);
    }
}