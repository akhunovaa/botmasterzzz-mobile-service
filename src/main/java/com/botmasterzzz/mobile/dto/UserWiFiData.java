package com.botmasterzzz.mobile.dto;

import com.fasterxml.jackson.annotation.*;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ssid",
        "bssid",
        "channel",
        "rssi",
        "cc",
        "security",
        "distance",
        "primary_frequency",
        "center_frequency",
        "end_frequency",
        "is_80211_mc",
        "created_time",
        "created",
        "changed"
})
public class UserWiFiData {

    @JsonProperty("data_id")
    @JsonIgnore
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

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("primary_frequency")
    private int primaryFrequency;

    @JsonProperty("center_frequency")
    private int centerFrequency;

    @JsonProperty("end_frequency")
    private int endFrequency;

    @JsonProperty("is_80211_mc")
    private boolean is80211mc;

    @JsonProperty("created_time")
    private Timestamp createdTime;

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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getPrimaryFrequency() {
        return primaryFrequency;
    }

    public void setPrimaryFrequency(int primaryFrequency) {
        this.primaryFrequency = primaryFrequency;
    }

    public int getCenterFrequency() {
        return centerFrequency;
    }

    public void setCenterFrequency(int centerFrequency) {
        this.centerFrequency = centerFrequency;
    }

    public int getEndFrequency() {
        return endFrequency;
    }

    public void setEndFrequency(int endFrequency) {
        this.endFrequency = endFrequency;
    }

    public boolean isIs80211mc() {
        return is80211mc;
    }

    public void setIs80211mc(boolean is80211mc) {
        this.is80211mc = is80211mc;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
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
                ", distance='" + distance + '\'' +
                ", primaryFrequency=" + primaryFrequency +
                ", centerFrequency=" + centerFrequency +
                ", endFrequency=" + endFrequency +
                ", is80211mc=" + is80211mc +
                ", createdTime=" + createdTime +
                ", whenCreated=" + whenCreated +
                ", whenUpdated=" + whenUpdated +
                '}';
    }
}
