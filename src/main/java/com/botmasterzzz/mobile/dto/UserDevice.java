package com.botmasterzzz.mobile.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Timestamp;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "device_id",
        "model_name",
        "os_version",
        "mac_address",
        "ip_address",
        "wifi_data",
        "created",
        "changed"
})
public class UserDevice {

    @JsonProperty("device_id")
    private long id;

    @JsonProperty("model_name")
    private String modelName;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("mac_address")
    private String macAddress;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("created")
    private Timestamp whenCreated;

    @JsonProperty("changed")
    private Timestamp whenUpdated;

    @JsonProperty("wifi_data")
    private List<UserWiFiData> userWiFiDataList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public Timestamp getWhenUpdated() {
        return whenUpdated;
    }

    public void setWhenUpdated(Timestamp whenUpdated) {
        this.whenUpdated = whenUpdated;
    }

    public List<UserWiFiData> getUserWiFiDataList() {
        return userWiFiDataList;
    }

    public void setUserWiFiDataList(List<UserWiFiData> userWiFiDataList) {
        this.userWiFiDataList = userWiFiDataList;
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", whenCreated=" + whenCreated +
                ", whenUpdated=" + whenUpdated +
                ", userWiFiDataList=" + userWiFiDataList +
                '}';
    }
}
