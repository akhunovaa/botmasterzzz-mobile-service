package com.botmasterzzz.mobile.service;

import com.botmasterzzz.mobile.dto.UserDevice;

import java.util.List;

public interface WiFiDataService {

    Long userDeviceAdd(UserDevice userDevice);

    UserDevice userDeviceGet(long id);

    List<UserDevice> getUserDeviceList();

    List<UserDevice> getUserDeviceList(long userId);

    UserDevice userDeviceDelete(long userId);

    UserDevice userDeviceDelete(UserDevice userDevice);

    UserDevice userDeviceUpdate(UserDevice userDevice);
}
