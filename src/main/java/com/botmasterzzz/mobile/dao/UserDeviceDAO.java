package com.botmasterzzz.mobile.dao;

import com.botmasterzzz.mobile.entity.UserDeviceEntity;

import java.util.List;

public interface UserDeviceDAO {

    void userDeviceAdd(UserDeviceEntity userDeviceEntity);

    List<UserDeviceEntity> getUserDeviceList();

    List<UserDeviceEntity> getUserDeviceList(long userId);

    void userDeviceDelete(long userId);

    void userDeviceDelete(UserDeviceEntity userDevice);

    void userDeviceUpdate(UserDeviceEntity userDevice);

}
