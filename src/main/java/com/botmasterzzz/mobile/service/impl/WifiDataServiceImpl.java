package com.botmasterzzz.mobile.service.impl;

import com.botmasterzzz.mobile.dao.UserDeviceDAO;
import com.botmasterzzz.mobile.dto.User;
import com.botmasterzzz.mobile.dto.UserDevice;
import com.botmasterzzz.mobile.dto.UserDeviceNetTest;
import com.botmasterzzz.mobile.dto.UserWiFiData;
import com.botmasterzzz.mobile.entity.UserDeviceEntity;
import com.botmasterzzz.mobile.entity.UserDeviceNetTestEntity;
import com.botmasterzzz.mobile.entity.UserEntity;
import com.botmasterzzz.mobile.entity.UserWiFiDataEntity;
import com.botmasterzzz.mobile.exception.CustomException;
import com.botmasterzzz.mobile.service.WiFiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@EnableAsync
public class WifiDataServiceImpl implements WiFiDataService {

    @Autowired
    private UserDeviceDAO userDeviceDAO;

    @Override
    public void userDeviceAdd(UserDevice userDevice) {
        UserDeviceEntity userDeviceEntity = new UserDeviceEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDevice.getUserId());
        userDeviceEntity.setIpAddress(userDevice.getIpAddress());
        userDeviceEntity.setMacAddress(userDevice.getMacAddress());
        userDeviceEntity.setModelName(userDevice.getModelName());
        userDeviceEntity.setOsVersion(userDevice.getOsVersion());
        userDeviceEntity.setExtIpAddress(userDevice.getExtIpAddress());
        userDeviceEntity.setUserWiFiDataEntityList(new HashSet<>(userDevice.getUserWiFiDataList().size()));
        userDeviceEntity.setLinkSpeed(userDevice.getLinkSpeed());
        for (UserWiFiData userWiFiData : userDevice.getUserWiFiDataList()) {
            UserWiFiDataEntity userWiFiDataEntity = new UserWiFiDataEntity();
            userWiFiDataEntity.setBssid(userWiFiData.getBssid());
            userWiFiDataEntity.setCc(userWiFiData.getCc());
            userWiFiDataEntity.setChannel(userWiFiData.getChannel());
            userWiFiDataEntity.setRssi(userWiFiData.getRssi());
            userWiFiDataEntity.setSecurity(userWiFiData.getSecurity());
            userWiFiDataEntity.setSsid(userWiFiData.getSsid());
            userWiFiDataEntity.setDistance(userWiFiData.getDistance());
            userWiFiDataEntity.setPrimaryFrequency(userWiFiData.getPrimaryFrequency());
            userWiFiDataEntity.setCenterFrequency(userWiFiData.getCenterFrequency());
            userWiFiDataEntity.setEndFrequency(userWiFiData.getEndFrequency());
            userWiFiDataEntity.setIs80211mc(userWiFiData.isIs80211mc());
            userWiFiDataEntity.setCreatedTime(userWiFiData.getCreatedTime());
            userDeviceEntity.addUserWifiData(userWiFiDataEntity);
        }
        userDeviceEntity.setUserEntity(userEntity);
        userDeviceDAO.userDeviceAdd(userDeviceEntity);
        userDevice.setId(userDeviceEntity.getId());
    }

    @Override
    public void userNetTestAdd(UserDeviceNetTest userDeviceNetTest) throws CustomException {
        UserDeviceNetTestEntity userDeviceNetTestEntity = new UserDeviceNetTestEntity();
        userDeviceNetTestEntity.setRate(userDeviceNetTest.getRate());
        userDeviceNetTestEntity.setSent(userDeviceNetTest.getSent());
        UserDeviceEntity userDeviceEntity = userDeviceDAO.getUserDevice(userDeviceNetTest.getMacddress(), userDeviceNetTest.getUserId());
        userDeviceNetTestEntity.setUserDeviceEntity(userDeviceEntity);
        userDeviceDAO.userDeviceNetTestAdd(userDeviceNetTestEntity);
    }

    @Override
    public List<UserDevice> getUserDeviceList() {
        List<UserDeviceEntity> userDeviceEntityList = userDeviceDAO.getUserDeviceList();
        List<UserDevice> userDeviceList = new ArrayList<>(userDeviceEntityList.size());
        for (UserDeviceEntity userDeviceEntity : userDeviceEntityList) {
            UserDevice userDevice = new UserDevice();
            userDevice.setId(userDeviceEntity.getId());
            userDevice.setIpAddress(userDeviceEntity.getIpAddress());
            userDevice.setMacAddress(userDeviceEntity.getMacAddress());
            userDevice.setModelName(userDeviceEntity.getModelName());
            userDevice.setOsVersion(userDeviceEntity.getOsVersion());
            userDevice.setExtIpAddress(userDeviceEntity.getExtIpAddress());
            userDevice.setWhenCreated(userDeviceEntity.getAudWhenCreate());
            userDevice.setWhenUpdated(userDeviceEntity.getAudWhenUpdate());
            userDevice.setUserId(userDeviceEntity.getUserEntity().getId());
            userDevice.setLinkSpeed(userDeviceEntity.getLinkSpeed());
            userDevice.setUser(new User(userDeviceEntity.getUserEntity().getLogin(), userDeviceEntity.getUserEntity().getEmail()));
            for (UserWiFiDataEntity userWiFiDataEntity : userDeviceEntity.getUserWiFiDataEntityList()) {
                UserWiFiData userWiFiData = new UserWiFiData();
                userWiFiData.setBssid(userWiFiDataEntity.getBssid());
                userWiFiData.setCc(userWiFiDataEntity.getCc());
                userWiFiData.setChannel(userWiFiDataEntity.getChannel());
                userWiFiData.setId(userWiFiDataEntity.getId());
                userWiFiData.setRssi(userWiFiDataEntity.getRssi());
                userWiFiData.setSecurity(userWiFiDataEntity.getSecurity());
                userWiFiData.setSsid(userWiFiDataEntity.getSsid());
                userWiFiData.setDistance(userWiFiDataEntity.getDistance());
                userWiFiData.setPrimaryFrequency(userWiFiDataEntity.getPrimaryFrequency());
                userWiFiData.setCenterFrequency(userWiFiDataEntity.getCenterFrequency());
                userWiFiData.setEndFrequency(userWiFiDataEntity.getEndFrequency());
                userWiFiData.setIs80211mc(userWiFiDataEntity.isIs80211mc());
                userWiFiData.setCreatedTime(userWiFiDataEntity.getCreatedTime());
                userWiFiData.setWhenCreated(userWiFiDataEntity.getAudWhenCreate());
                userWiFiData.setWhenUpdated(userWiFiDataEntity.getAudWhenUpdate());
                userDevice.addUserWifiData(userWiFiData);
            }
            for (UserDeviceNetTestEntity userDeviceNetTestEntity : userDeviceEntity.getUserDeviceNetTestEntitySet()) {
                UserDeviceNetTest userDeviceNetTest = new UserDeviceNetTest();
                userDeviceNetTest.setRate(userDeviceNetTestEntity.getRate());
                userDeviceNetTest.setSent(userDeviceNetTestEntity.getSent());
                userDeviceNetTest.setId(userDeviceNetTestEntity.getId());
                userDeviceNetTest.setWhenCreated(userDeviceNetTestEntity.getAudWhenCreate());
                userDeviceNetTest.setWhenUpdated(userDeviceNetTestEntity.getAudWhenUpdate());
                userDevice.addUserNetTestData(userDeviceNetTest);
            }
            userDeviceList.add(userDevice);
        }
        return userDeviceList;
    }

    @Override
    public List<UserDevice> getUserDeviceList(long userId) {
        List<UserDeviceEntity> userDeviceEntityList = userDeviceDAO.getUserDeviceList(userId);
        List<UserDevice> userDeviceList = new ArrayList<>(userDeviceEntityList.size());
        for (UserDeviceEntity userDeviceEntity : userDeviceEntityList) {
            UserDevice userDevice = new UserDevice();
            userDevice.setId(userDeviceEntity.getId());
            userDevice.setIpAddress(userDeviceEntity.getIpAddress());
            userDevice.setMacAddress(userDeviceEntity.getMacAddress());
            userDevice.setModelName(userDeviceEntity.getModelName());
            userDevice.setOsVersion(userDeviceEntity.getOsVersion());
            userDevice.setExtIpAddress(userDeviceEntity.getExtIpAddress());
            userDevice.setWhenCreated(userDeviceEntity.getAudWhenCreate());
            userDevice.setWhenUpdated(userDeviceEntity.getAudWhenUpdate());
            userDevice.setUserId(userDeviceEntity.getUserEntity().getId());
            userDevice.setLinkSpeed(userDeviceEntity.getLinkSpeed());
            userDevice.setUser(new User(userDeviceEntity.getUserEntity().getLogin(), userDeviceEntity.getUserEntity().getEmail()));
            for (UserWiFiDataEntity userWiFiDataEntity : userDeviceEntity.getUserWiFiDataEntityList()) {
                UserWiFiData userWiFiData = new UserWiFiData();
                userWiFiData.setBssid(userWiFiDataEntity.getBssid());
                userWiFiData.setCc(userWiFiDataEntity.getCc());
                userWiFiData.setChannel(userWiFiDataEntity.getChannel());
                userWiFiData.setId(userWiFiDataEntity.getId());
                userWiFiData.setRssi(userWiFiDataEntity.getRssi());
                userWiFiData.setSecurity(userWiFiDataEntity.getSecurity());
                userWiFiData.setSsid(userWiFiDataEntity.getSsid());
                userWiFiData.setDistance(userWiFiDataEntity.getDistance());
                userWiFiData.setPrimaryFrequency(userWiFiDataEntity.getPrimaryFrequency());
                userWiFiData.setCenterFrequency(userWiFiDataEntity.getCenterFrequency());
                userWiFiData.setEndFrequency(userWiFiDataEntity.getEndFrequency());
                userWiFiData.setIs80211mc(userWiFiDataEntity.isIs80211mc());
                userWiFiData.setCreatedTime(userWiFiDataEntity.getCreatedTime());
                userWiFiData.setWhenCreated(userWiFiDataEntity.getAudWhenCreate());
                userWiFiData.setWhenUpdated(userWiFiDataEntity.getAudWhenUpdate());
                userDevice.addUserWifiData(userWiFiData);
            }
            for (UserDeviceNetTestEntity userDeviceNetTestEntity : userDeviceEntity.getUserDeviceNetTestEntitySet()) {
                UserDeviceNetTest userDeviceNetTest = new UserDeviceNetTest();
                userDeviceNetTest.setRate(userDeviceNetTestEntity.getRate());
                userDeviceNetTest.setSent(userDeviceNetTestEntity.getSent());
                userDeviceNetTest.setId(userDeviceNetTestEntity.getId());
                userDeviceNetTest.setWhenCreated(userDeviceNetTestEntity.getAudWhenCreate());
                userDeviceNetTest.setWhenUpdated(userDeviceNetTestEntity.getAudWhenUpdate());
                userDevice.addUserNetTestData(userDeviceNetTest);
            }
            userDeviceList.add(userDevice);
        }
        return userDeviceList;
    }

    @Async
    @Override
    public void userDeviceDelete(long deviceId) {
        userDeviceDAO.userDeviceDelete(deviceId);
    }

    @Async
    @Override
    public void userDeviceDelete(UserDevice userDevice) {
        UserDeviceEntity userDeviceEntity = new UserDeviceEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDevice.getUserId());
        userDeviceEntity.setIpAddress(userDevice.getIpAddress());
        userDeviceEntity.setMacAddress(userDevice.getMacAddress());
        userDeviceEntity.setModelName(userDevice.getModelName());
        userDeviceEntity.setOsVersion(userDevice.getOsVersion());
        userDeviceEntity.setUserWiFiDataEntityList(new HashSet<>(userDevice.getUserWiFiDataList().size()));
        for (UserWiFiData userWiFiData : userDevice.getUserWiFiDataList()) {
            UserWiFiDataEntity userWiFiDataEntity = new UserWiFiDataEntity();
            userWiFiDataEntity.setBssid(userWiFiData.getBssid());
            userWiFiDataEntity.setCc(userWiFiData.getCc());
            userWiFiDataEntity.setChannel(userWiFiData.getChannel());
            userWiFiDataEntity.setRssi(userWiFiData.getRssi());
            userWiFiDataEntity.setSecurity(userWiFiData.getSecurity());
            userWiFiDataEntity.setSsid(userWiFiData.getSsid());
            userDeviceEntity.addUserWifiData(userWiFiDataEntity);
        }
        userDeviceEntity.setUserEntity(userEntity);
        userDeviceDAO.userDeviceDelete(userDeviceEntity);
    }

    @Async
    @Override
    public void userDeviceUpdate(UserDevice userDevice) {
        UserDeviceEntity userDeviceEntity = new UserDeviceEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDevice.getUserId());
        userDeviceEntity.setIpAddress(userDevice.getIpAddress());
        userDeviceEntity.setMacAddress(userDevice.getMacAddress());
        userDeviceEntity.setModelName(userDevice.getModelName());
        userDeviceEntity.setExtIpAddress(userDevice.getExtIpAddress());
        userDeviceEntity.setOsVersion(userDevice.getOsVersion());
        userDeviceEntity.setUserWiFiDataEntityList(new HashSet<>(userDevice.getUserWiFiDataList().size()));
        for (UserWiFiData userWiFiData : userDevice.getUserWiFiDataList()) {
            UserWiFiDataEntity userWiFiDataEntity = new UserWiFiDataEntity();
            userWiFiDataEntity.setBssid(userWiFiData.getBssid());
            userWiFiDataEntity.setCc(userWiFiData.getCc());
            userWiFiDataEntity.setChannel(userWiFiData.getChannel());
            userWiFiDataEntity.setRssi(userWiFiData.getRssi());
            userWiFiDataEntity.setSecurity(userWiFiData.getSecurity());
            userWiFiDataEntity.setSsid(userWiFiData.getSsid());
            userWiFiDataEntity.setDistance(userWiFiData.getDistance());
            userWiFiDataEntity.setPrimaryFrequency(userWiFiData.getPrimaryFrequency());
            userWiFiDataEntity.setCenterFrequency(userWiFiData.getCenterFrequency());
            userWiFiDataEntity.setEndFrequency(userWiFiData.getEndFrequency());
            userWiFiDataEntity.setIs80211mc(userWiFiData.isIs80211mc());
            userWiFiDataEntity.setCreatedTime(userWiFiData.getCreatedTime());
            userDeviceEntity.addUserWifiData(userWiFiDataEntity);
        }
        userDeviceEntity.setUserEntity(userEntity);
        userDeviceDAO.userDeviceUpdate(userDeviceEntity);
    }
}
