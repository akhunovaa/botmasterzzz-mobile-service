package com.botmasterzzz.mobile.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_wifi_data")
public class UserWiFiDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ssid")
    private String ssid;

    @Column(name = "bssid")
    private String bssid;

    @Column(name = "channel")
    private String channel;

    @Column(name = "rssi")
    private String rssi;

    @Column(name = "cc")
    private String cc;

    @Column(name = "security")
    private String security;

    @Column(name = "note")
    private String note;

    @JoinColumn(name = "device_id")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private UserDeviceEntity userDeviceEntity;

    @Column(name = "distance")
    private String distance;

    @Column(name = "primary_frequency")
    private int primaryFrequency;

    @Column(name = "center_frequency")
    private int centerFrequency;

    @Column(name = "end_frequency")
    private int endFrequency;

    @Column(name = "is_80211_mc")
    private boolean is80211mc;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "aud_when_create")
    private Timestamp audWhenCreate;

    @Column(name = "aud_when_update")
    private Timestamp audWhenUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserDeviceEntity getUserDeviceEntity() {
        return userDeviceEntity;
    }

    public void setUserDeviceEntity(UserDeviceEntity userDeviceEntity) {
        this.userDeviceEntity = userDeviceEntity;
    }

    public Timestamp getAudWhenCreate() {
        return audWhenCreate;
    }

    public void setAudWhenCreate(Timestamp audWhenCreate) {
        this.audWhenCreate = audWhenCreate;
    }

    public Timestamp getAudWhenUpdate() {
        return audWhenUpdate;
    }

    public void setAudWhenUpdate(Timestamp audWhenUpdate) {
        this.audWhenUpdate = audWhenUpdate;
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
        return "UserWiFiDataEntity{" +
                "id=" + id +
                ", ssid='" + ssid + '\'' +
                ", bssid='" + bssid + '\'' +
                ", channel='" + channel + '\'' +
                ", rssi='" + rssi + '\'' +
                ", cc='" + cc + '\'' +
                ", security='" + security + '\'' +
                ", note='" + note + '\'' +
                ", userDeviceEntity=" + userDeviceEntity +
                ", distance='" + distance + '\'' +
                ", primaryFrequency=" + primaryFrequency +
                ", centerFrequency=" + centerFrequency +
                ", endFrequency=" + endFrequency +
                ", is80211mc=" + is80211mc +
                ", createdTime=" + createdTime +
                ", audWhenCreate=" + audWhenCreate +
                ", audWhenUpdate=" + audWhenUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWiFiDataEntity that = (UserWiFiDataEntity) o;
        return primaryFrequency == that.primaryFrequency &&
                centerFrequency == that.centerFrequency &&
                endFrequency == that.endFrequency &&
                is80211mc == that.is80211mc &&
                Objects.equals(id, that.id) &&
                Objects.equals(ssid, that.ssid) &&
                Objects.equals(bssid, that.bssid) &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(rssi, that.rssi) &&
                Objects.equals(cc, that.cc) &&
                Objects.equals(security, that.security) &&
                Objects.equals(note, that.note) &&
                Objects.equals(userDeviceEntity, that.userDeviceEntity) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(audWhenCreate, that.audWhenCreate) &&
                Objects.equals(audWhenUpdate, that.audWhenUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ssid, bssid, channel, rssi, cc, security, note, userDeviceEntity, distance, primaryFrequency, centerFrequency, endFrequency, is80211mc, createdTime, audWhenCreate, audWhenUpdate);
    }
}
