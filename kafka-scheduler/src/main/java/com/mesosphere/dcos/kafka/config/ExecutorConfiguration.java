package com.mesosphere.dcos.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ExecutorConfiguration {
    @JsonProperty("cpus")
    private double cpus;
    @JsonProperty("mem")
    private double mem;
    @JsonProperty("disk")
    private double disk;
    @JsonProperty("executor_uri")
    private String executorUri;
    @JsonProperty("host_path")
    private String hostPath;
    @JsonProperty("container_path")
    private String containerPath;
    @JsonProperty("network_mode")
    private String networkMode;
    @JsonProperty("cni_network")
    private String cniNetwork;

    public ExecutorConfiguration() {

    }

    @JsonCreator
    public ExecutorConfiguration(
            @JsonProperty("cpus")double cpus,
            @JsonProperty("mem")double mem,
            @JsonProperty("disk")double disk,
            @JsonProperty("executor_uri")String executorUri,
            @JsonProperty("host_path") String hostPath,
            @JsonProperty("container_path") String containerPath,
            @JsonProperty("network_mode")String networkMode,
            @JsonProperty("cni_network")String cniNetwork) {
        this.cpus = cpus;
        this.mem = mem;
        this.disk = disk;
        this.executorUri = executorUri;
        this.hostPath = hostPath;
        this.containerPath = containerPath;
        this.networkMode = networkMode;
        this.cniNetwork = cniNetwork;
    }

    public double getCpus() {
        return cpus;
    }

    @JsonProperty("cpus")
    public void setCpus(double cpus) {
        this.cpus = cpus;
    }

    public double getMem() {
        return mem;
    }

    public String getHostPath(){
        return hostPath;
    }

    @JsonProperty("host_path")
    public void setHostPath(String hostPath){
        this.hostPath = hostPath;
    }

    @JsonProperty("mem")
    public void setMem(double mem) {
        this.mem = mem;
    }

    @JsonProperty("disk")
    public double getDisk() {
        return disk;
    }

    @JsonProperty("disk")
    public void setDisk(double disk) {
        this.disk = disk;
    }

    public String getExecutorUri() {
        return executorUri;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public String getCniNetwork() {
        return cniNetwork;
    }

    @JsonProperty("executor_uri")
    public void setExecutorUri(String executorUri) {
        this.executorUri = executorUri;
    }

    @JsonProperty("container_path")
    public void setContainerPath(String containerPath){
        this.containerPath = containerPath;
    }

    public String getContainerPath(){
        return containerPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExecutorConfiguration that = (ExecutorConfiguration) o;
        return Double.compare(that.cpus, cpus) == 0 &&
                Double.compare(that.mem, mem) == 0 &&
                Double.compare(that.disk, disk) == 0 &&
                Objects.equals(executorUri, that.executorUri) &&
                Objects.equals(hostPath, that.hostPath) &&
                Objects.equals(containerPath, that.containerPath) &&
                Objects.equals(networkMode, that.networkMode) &&
                Objects.equals(cniNetwork, that.cniNetwork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpus, mem, disk, executorUri, hostPath, containerPath, networkMode, cniNetwork);
    }

    @Override
    public String toString() {
        return "ExecutorConfiguration{" +
                "cpus=" + cpus +
                ", mem=" + mem +
                ", disk=" + disk +
                ", executorUri='" + executorUri + '\'' +
                ", hostPath=" + hostPath +
                ", containerPath=" + containerPath +
                ", networkMode='" + networkMode + '\'' +
                ", cniNetwork='" + cniNetwork + '\'' +
                '}';
    }
}
