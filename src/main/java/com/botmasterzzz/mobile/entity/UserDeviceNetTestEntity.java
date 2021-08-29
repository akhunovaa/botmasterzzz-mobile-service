package com.botmasterzzz.mobile.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_wifi_net_test")
public class UserDeviceNetTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sent")
    private String sent;

    @Column(name = "rate")
    private String rate;

    @JoinColumn(name = "device_id")
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private UserDeviceEntity userDeviceEntity;

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
}
