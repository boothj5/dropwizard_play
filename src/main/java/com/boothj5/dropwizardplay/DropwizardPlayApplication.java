package com.boothj5.dropwizardplay;

import com.boothj5.dropwizardplay.healthcheck.JenkinsHealthCheck;
import com.boothj5.dropwizardplay.infrastructure.externalsystem.JenkinsClient;
import com.boothj5.dropwizardplay.resource.JenkinsResource;
import com.boothj5.dropwizardplay.resource.PersonResource;
import com.boothj5.dropwizardplay.resource.SysInfoResource;
import com.boothj5.dropwizardplay.infrastructure.system.SystemInformationService;
import com.boothj5.dropwizardplay.infrastructure.store.PersonStore;
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
        final JenkinsHealthCheck healthCheck =
                new JenkinsHealthCheck(configuration.getJenkinsHost());
        environment.healthChecks().register("jenkins", healthCheck);

        environment.jersey().register(GlobalExceptionMapper.class);

        SystemInformationService sysInfoService = new SystemInformationService();
        environment.jersey().register(new SysInfoResource(sysInfoService));

        PersonStore personStore = new PersonStore();
        environment.jersey().register(new PersonResource(personStore));

        JenkinsClient jenkinsClient = new JenkinsClient(configuration.getJenkinsHost());
        environment.jersey().register(new JenkinsResource(jenkinsClient));
    }
}
