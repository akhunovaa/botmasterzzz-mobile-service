package com.botmasterzzz.mobile.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "data_id",
        "ssid",
        "bssid",
        "channel",
        "rssi",
        "cc",
        "security",
        "created",
        "changed"
})
public class UserWiFiData {

    @JsonProperty("data_id")
    private long id;

    @JsonProperty("ssid")
    private String ssid;

    @JsonProperty("bssid")
    private String bssid;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("rssi")
    private String rssi;

    @JsonProperty("cc")
    private String cc;

    @JsonProperty("security")
    private String security;

    @JsonProperty("created")
    private Timestamp whenCreated;

    @JsonProperty("changed")
    private Timestamp whenUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
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

    @Override
    public String toString() {
        return "UserWiFiData{" +
                "id=" + id +
                ", ssid='" + ssid + '\'' +
                ", bssid='" + bssid + '\'' +
                ", channel='" + channel + '\'' +
                ", rssi='" + rssi + '\'' +
                ", cc='" + cc + '\'' +
                ", security='" + security + '\'' +
                ", whenCreated=" + whenCreated +
                ", whenUpdated=" + whenUpdated +
                '}';
    }
}
