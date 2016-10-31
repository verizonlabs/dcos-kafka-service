package com.mesosphere.dcos.kafka.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ServiceConfiguration {
    @JsonProperty("count")
    private int count;
    @JsonProperty("name")
    private String name;
    @JsonProperty("user")
    private String user;
    @JsonProperty("placement_strategy")
    private String placementStrategy;
    @JsonProperty("phase_strategy")
    private String phaseStrategy;
    @JsonProperty("role")
    private String role;
    @JsonProperty("principal")
    private String principal;
    @JsonProperty("host_list_filter")
    private List<String> hostListFilter;

    public ServiceConfiguration() {

    }

    @JsonCreator
    public ServiceConfiguration(
            @JsonProperty("count")int count,
            @JsonProperty("name")String name,
            @JsonProperty("user")String user,
            @JsonProperty("placement_strategy")String placementStrategy,
            @JsonProperty("phase_strategy")String phaseStrategy,
            @JsonProperty("role")String role,
            @JsonProperty("principal")String principal,
            @JsonProperty("host_list_filter")List<String> hostListFilter) {
        this.count = count;
        this.name = name;
        this.user = user;
        this.placementStrategy = placementStrategy;
        this.phaseStrategy = phaseStrategy;
        this.role = role;
        this.principal = principal;
        this.hostListFilter = hostListFilter;
    }

    public int getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public String getPlacementStrategy() {
        return placementStrategy;
    }

    @JsonProperty("placement_strategy")
    public void setPlacementStrategy(String placementStrategy) {
        this.placementStrategy = placementStrategy;
    }

    public String getPhaseStrategy() {
        return phaseStrategy;
    }

    @JsonProperty("phase_strategy")
    public void setPhaseStrategy(String phaseStrategy) {
        this.phaseStrategy = phaseStrategy;
    }

    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    public String getPrincipal() {
        return principal;
    }

    @JsonProperty("principal")
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @JsonProperty("host_list_filter")
    public void setHostListFilter(List<String> hostListFilter) { this.hostListFilter = hostListFilter; }

    public List<String> getHostListFilter(){ return this.hostListFilter; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServiceConfiguration that = (ServiceConfiguration) o;
        return count == that.count &&
                Objects.equals(name, that.name) &&
                Objects.equals(user, that.user) &&
                Objects.equals(placementStrategy, that.placementStrategy) &&
                Objects.equals(phaseStrategy, that.phaseStrategy) &&
                Objects.equals(role, that.role) &&
                Objects.equals(principal, that.principal) &&
                Objects.equals(hostListFilter, that.hostListFilter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, name, user, placementStrategy, phaseStrategy, role, principal, hostListFilter);
    }

    @Override
    public String toString() {
        return "ServiceConfiguration{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", placementStrategy='" + placementStrategy + '\'' +
                ", phaseStrategy='" + phaseStrategy + '\'' +
                ", role='" + role + '\'' +
                ", principal='" + principal + '\'' +
                ", hostListFilter=" + hostListFilter +
                '}';
    }
}
