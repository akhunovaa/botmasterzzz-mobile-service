package com.botmasterzzz.mobile.dto;

import com.fasterxml.jackson.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "sent",
        "rate",
        "device",
        "user",
        "created",
        "changed"
})
public class UserDeviceNetTest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("sent")
    private String sent;

    @JsonProperty("rate")
    private String rate;

    @JsonProperty("device")
    private UserDevice userDevice;

    @JsonProperty("mac_address")
    private String macddress;

    @JsonProperty("user")
    private User user;

    @JsonProperty("user_id")
    private Long userId;

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

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getMacddress() {
        return macddress;
    }

    public void setMacddress(String macddress) {
        this.macddress = macddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
