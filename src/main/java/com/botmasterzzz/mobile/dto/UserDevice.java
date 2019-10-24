package com.botmasterzzz.mobile.dto;

import com.fasterxml.jackson.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "device_id",
        "model_name",
        "os_version",
        "mac_address",
        "ip_address",
        "user",
        "ext_ip_address",
        "link_speed",
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

    @JsonProperty("user")
    private User user;

    @JsonProperty("ext_ip_address")
    private String extIpAddress;

    @JsonProperty("link_speed")
    private Integer linkSpeed;

    @JsonProperty("created")
    private Timestamp whenCreated;

    @JsonProperty("changed")
    private Timestamp whenUpdated;

    @JsonProperty("wifi_data")
    private List<UserWiFiData> userWiFiDataList;

    @JsonProperty("net_test")
    private List<UserDeviceNetTest> userDeviceNetTestList;


    @JsonIgnore
    private long userId;

    public void addUserWifiData(UserWiFiData userWiFiData) {
        if (null == userWiFiDataList){
            userWiFiDataList = new ArrayList<>();
        }
        userWiFiDataList.add(userWiFiData);
    }

    public void addUserNetTestData(UserDeviceNetTest userDeviceNetTest) {
        if (null == userDeviceNetTestList){
            userDeviceNetTestList = new ArrayList<>();
        }
        userDeviceNetTestList.add(userDeviceNetTest);
    }


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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExtIpAddress() {
        return extIpAddress;
    }

    public void setExtIpAddress(String extIpAddress) {
        this.extIpAddress = extIpAddress;
    }

    public Integer getLinkSpeed() {
        return linkSpeed;
    }

    public void setLinkSpeed(Integer linkSpeed) {
        this.linkSpeed = linkSpeed;
    }

    public List<UserDeviceNetTest> getUserDeviceNetTestList() {
        return userDeviceNetTestList;
    }

    public void setUserDeviceNetTestList(List<UserDeviceNetTest> userDeviceNetTestList) {
        this.userDeviceNetTestList = userDeviceNetTestList;
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", user=" + user +
                ", extIpAddress='" + extIpAddress + '\'' +
                ", linkSpeed=" + linkSpeed +
                ", whenCreated=" + whenCreated +
                ", whenUpdated=" + whenUpdated +
                ", userWiFiDataList=" + userWiFiDataList +
                ", userDeviceNetTestList=" + userDeviceNetTestList +
                ", userId=" + userId +
                '}';
    }
}
