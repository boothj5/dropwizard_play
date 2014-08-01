package com.boothj5.dropwizardplay;

import com.boothj5.dropwizardplay.resources.SysInfoResource;
import com.boothj5.dropwizardplay.service.SystemInformationService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardPlayApplication extends Application<DropwizardPlayConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardPlayApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard_play";
    }

    @Override
    public void initialize(Bootstrap<DropwizardPlayConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropwizardPlayConfiguration configuration, Environment environment) {
        environment.jersey().register(GlobalExceptionMapper.class);

        SystemInformationService sysInfoService = new SystemInformationService();
        environment.jersey().register(new SysInfoResource(sysInfoService));
    }
}
