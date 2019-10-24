package com.botmasterzzz.mobile.dao;

import com.botmasterzzz.mobile.entity.UserDeviceEntity;
import com.botmasterzzz.mobile.entity.UserDeviceNetTestEntity;

import java.util.List;

public interface UserDeviceDAO {

    void userDeviceAdd(UserDeviceEntity userDeviceEntity);

    void userDeviceNetTestAdd(UserDeviceNetTestEntity userDeviceNetTestEntity);

    List<UserDeviceEntity> getUserDeviceList();

    UserDeviceEntity getUserDevice(String macAddress, Long userId);

    List<UserDeviceEntity> getUserDeviceList(long userId);

    void userDeviceDelete(long deviceId);

    void userDeviceDelete(UserDeviceEntity userDevice);

    void userDeviceUpdate(UserDeviceEntity userDevice);

}
