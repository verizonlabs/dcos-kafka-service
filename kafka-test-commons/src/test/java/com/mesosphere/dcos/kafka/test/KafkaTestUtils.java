package com.mesosphere.dcos.kafka.test;

import org.apache.mesos.Protos;
import org.apache.mesos.offer.TaskUtils;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class provides commons utilities for Kafka tests.
 */
public class KafkaTestUtils {
    public static final String testRole = "test-role";
    public static final String testPrincipal = "test-principal";
    public static final String testResourceId = "test-resource-id";
    public static final String testTaskName = "broker-0";
    public static final String testHostPath = "/var/log/";
    public static final String testContainerPath = "logs";
    public static final String testCommand = "./executor/bin/kafka-executor server ./executor/conf/executor.yml";
    public static final String testNetworkMode = "host";
    public static final String testCniNetwork = "dcos";
    public static final String testVolumeName = "kafka_test";
    public static final String testVolumeDriver = "rexray";
    public static final String testDvdcli = "file:///opt/mesosphere/bin/dvdcli";
    public static final ArrayList<String> testHostFilter = new ArrayList<String>() {{ add("SDS"); add("POD1"); }};
    public static final Protos.TaskID testTaskId = TaskUtils.toTaskId(testTaskName);
    public static final String testSlaveId = "test-slave-id";
    public static final String testConfigName = UUID.randomUUID().toString();
    public static final String testFrameworkName = "test-framework-name";
    public static final String testUser = "test-user";
    public static final String testPlacementStrategy = "test-placement-strategy";
    public static final String testPhaseStrategy = "test-phase-strategy";
    public static final String testDiskType = "test-disk-type";
    public static final String testKafkaUri = "test-kafka-uri";
    public static final String testJavaUri = "test-java-uri";
    public static final String testOverriderUri = "test-overrider-uri";
    public static final Long testPort = 9092L;
    public static final String testExecutorName = "test-executor-name";
    public static final String testExecutorUri = "test-executor-uri";
    public static final String testKafkaVerName = "test-kafka-ver-name";
    public static final String testKafkaSandboxPath = "test-kafka-sandbox-path";
    public static final String testKafkaZkUri = "test-kafka-zk-uri";
    public static final String testMesosZkUri = "test-mesos-zk-uri";
    public static final String testOfferId = "test-offer-id";
    public static final String testHostname = "test-hostname";
    public static final Protos.FrameworkID testFrameworkId =
            Protos.FrameworkID.newBuilder()
                    .setValue("test-kafka-framework-id")
                    .build();
}

