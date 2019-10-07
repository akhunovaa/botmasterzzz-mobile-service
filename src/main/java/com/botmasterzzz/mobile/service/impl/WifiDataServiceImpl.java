package com.botmasterzzz.mobile.service.impl;

import com.botmasterzzz.mobile.dto.UserDevice;
import com.botmasterzzz.mobile.service.WiFiDataService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAsync
public class WifiDataServiceImpl implements WiFiDataService {

    @Override
    public Long userDeviceAdd(UserDevice userDevice) {
        return null;
    }

    @Override
    public UserDevice userDeviceGet(long id) {
        return null;
    }

    @Override
    public List<UserDevice> getUserDeviceList() {
        return null;
    }

    @Override
    public List<UserDevice> getUserDeviceList(long userId) {
        return null;
    }

    @Override
    public UserDevice userDeviceDelete(long userId) {
        return null;
    }

    @Override
    public UserDevice userDeviceDelete(UserDevice userDevice) {
        return null;
    }

    @Override
    public UserDevice userDeviceUpdate(UserDevice userDevice) {
        return null;
    }
}
