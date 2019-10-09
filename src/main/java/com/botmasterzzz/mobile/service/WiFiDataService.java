package com.botmasterzzz.mobile.service;

import com.botmasterzzz.mobile.dto.UserDevice;
import com.botmasterzzz.mobile.exception.CustomException;

import java.util.List;

public interface WiFiDataService {

    void userDeviceAdd(UserDevice userDevice) throws CustomException;

    List<UserDevice> getUserDeviceList() throws CustomException;

    List<UserDevice> getUserDeviceList(long userId) throws CustomException;

    void userDeviceDelete(long deviceId) throws CustomException;

    void userDeviceDelete(UserDevice userDevice);

    void userDeviceUpdate(UserDevice userDevice);
}
