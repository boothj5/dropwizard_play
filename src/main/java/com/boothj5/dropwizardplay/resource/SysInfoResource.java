package com.boothj5.dropwizardplay.resource;

import com.boothj5.dropwizardplay.core.SystemInformation;
import com.boothj5.dropwizardplay.infrastructure.system.SystemInformationService;
import com.codahale.metrics.annotation.Timed;

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
    @Timed
    public SystemInformation systemInfo() {
        SystemInformation systemInformation = service.getSystemInformation();

        return systemInformation;
    }
}