package net.corevalue.springboot.demo.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileCheckAndSetEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication app) {
        System.out.println("======Now we will check for active profile===");
        if (env.getActiveProfiles().length == 0) {
            env.addActiveProfile("dev");
        }
    }
}
