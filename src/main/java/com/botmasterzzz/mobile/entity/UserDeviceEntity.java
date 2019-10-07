package com.botmasterzzz.mobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "user_device")
public class UserDeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "note")
    private String note;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.REFRESH)
    private UserEntity userEntity;

    @Column(name = "aud_when_create")
    private Timestamp audWhenCreate;

    @Column(name = "aud_when_update")
    private Timestamp audWhenUpdate;

    @JsonIgnore
    @OneToMany(
            mappedBy = "userDeviceEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<UserWiFiDataEntity> userWiFiDataEntityList;

    public void addUserWifiData(UserWiFiDataEntity userWiFiDataEntity) {
        userWiFiDataEntityList.add(userWiFiDataEntity);
        userWiFiDataEntity.setUserDeviceEntity(this);
    }

    public void removeComment(UserWiFiDataEntity userWiFiDataEntity) {
        userWiFiDataEntityList.remove(userWiFiDataEntity);
        userWiFiDataEntity.setUserDeviceEntity(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    public Set<UserWiFiDataEntity> getUserWiFiDataEntityList() {
        return userWiFiDataEntityList;
    }

    public void setUserWiFiDataEntityList(Set<UserWiFiDataEntity> userWiFiDataEntityList) {
        this.userWiFiDataEntityList = userWiFiDataEntityList;
    }

    @Override
    public String toString() {
        return "UserDeviceEntity{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", note='" + note + '\'' +
                ", userEntity=" + userEntity +
                ", audWhenCreate=" + audWhenCreate +
                ", audWhenUpdate=" + audWhenUpdate +
                ", userWiFiDataEntityList=" + userWiFiDataEntityList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDeviceEntity that = (UserDeviceEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(osVersion, that.osVersion) &&
                Objects.equals(macAddress, that.macAddress) &&
                Objects.equals(ipAddress, that.ipAddress) &&
                Objects.equals(note, that.note) &&
                Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(audWhenCreate, that.audWhenCreate) &&
                Objects.equals(audWhenUpdate, that.audWhenUpdate) &&
                Objects.equals(userWiFiDataEntityList, that.userWiFiDataEntityList);
    }

}
