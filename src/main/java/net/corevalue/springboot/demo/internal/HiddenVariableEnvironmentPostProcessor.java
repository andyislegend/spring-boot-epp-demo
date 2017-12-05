package net.corevalue.springboot.demo.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.Collections;

public class HiddenVariableEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment env, SpringApplication app) {
        if (Arrays.stream(env.getActiveProfiles())
                .anyMatch(profile -> profile.equalsIgnoreCase("dev"))) {
            MapPropertySource props = new MapPropertySource("CUSTOM_PROPS",
                    Collections.singletonMap("best.language", "GROOVY"));
            env.getPropertySources().addLast(props);
        }
    }
}
