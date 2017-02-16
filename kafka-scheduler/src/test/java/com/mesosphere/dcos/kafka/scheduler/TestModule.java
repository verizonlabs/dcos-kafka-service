package com.mesosphere.dcos.kafka.scheduler;

import com.google.inject.AbstractModule;
import com.mesosphere.dcos.kafka.config.KafkaSchedulerConfiguration;
import io.dropwizard.setup.Environment;

/**
 * A module for dependency injection when running unit tests.
 */
public class TestModule extends AbstractModule {
    private final KafkaSchedulerConfiguration configuration;
    private final Environment environment;

    public TestModule(
            final KafkaSchedulerConfiguration configuration,
            final Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(Environment.class).toInstance(this.environment);
        bind(KafkaSchedulerConfiguration.class).toInstance(this.configuration);
    }
}
