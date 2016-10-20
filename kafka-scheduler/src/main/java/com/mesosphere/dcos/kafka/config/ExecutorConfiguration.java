package com.mesosphere.dcos.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
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
    @JsonProperty("volume_name")
    private String volumeName;
    @JsonProperty("volume_driver")
    private String volumeDriver;
    @JsonProperty("dvdcli")
    private String dvdcli;
    @JsonProperty("host_filter")
    private ArrayList<String> hostFilter;

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
            @JsonProperty("volume_name") String volumeName,
            @JsonProperty("volume_driver") String volumeDriver,
            @JsonProperty("dvdcli") String dvdcli,
            @JsonProperty("host_filter") ArrayList<String> hostFilter) {
        this.cpus = cpus;
        this.mem = mem;
        this.disk = disk;
        this.executorUri = executorUri;
        this.hostPath = hostPath;
        this.containerPath = containerPath;
        this.volumeName = volumeName;
        this.volumeDriver = volumeDriver;
        this.dvdcli = dvdcli;
        this.hostFilter = hostFilter;
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

    @JsonProperty("volume_name")
    public void setVolumeName(String volumeName) { this.volumeName = volumeName; }

    public String getVolumeName() { return  volumeName; }

    @JsonProperty("volume_driver")
    public void setVolumeDriver(String volumeDriver) { this.volumeDriver = volumeDriver; }

    public String getVolumeDriver() { return  volumeDriver; }

    @JsonProperty("dvdcli")
    public void setDvdcli(String dvdcli) { this.dvdcli = dvdcli; }

    public String getDvdcli() { return dvdcli; }

    @JsonProperty("host_filter")
    public void setHostFilter(ArrayList<String> hostFilter) { this.hostFilter = hostFilter; }

    public ArrayList<String> getHostFilter(){ return hostFilter; }

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
                Objects.equals(volumeDriver, that.volumeDriver) &&
                Objects.equals(volumeName, that.volumeName) &&
                Objects.equals(dvdcli, that.dvdcli) &&
                Objects.equals(hostFilter, that.hostFilter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpus, mem, disk, executorUri, hostPath, containerPath, volumeDriver, volumeName, dvdcli, hostFilter);
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
                ", volumeName=" + volumeName +
                ", volumeDriver=" + volumeDriver +
                ", dvdcli=" + dvdcli +
                ", hostFilter=" + hostFilter.toString() +
                '}';
    }
}
