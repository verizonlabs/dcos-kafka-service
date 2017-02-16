package com.mesosphere.dcos.kafka.scheduler;

import com.google.inject.AbstractModule;
import com.mesosphere.dcos.kafka.config.KafkaSchedulerConfiguration;
import io.dropwizard.setup.Environment;

/**
 * Guice Module for initializing interfaces to implementations for the HDFS Scheduler.
 */
public class KafkaSchedulerModule extends AbstractModule {

  private final KafkaSchedulerConfiguration configuration;
  private final Environment environment;

  public KafkaSchedulerModule(
          KafkaSchedulerConfiguration configuration,
          Environment environment) {
    this.configuration = configuration;
    this.environment = environment;
  }

  @Override
  protected void configure() {
    bind(Environment.class).toInstance(this.environment);
    bind(KafkaSchedulerConfiguration.class).toInstance(this.configuration);
  }
}
