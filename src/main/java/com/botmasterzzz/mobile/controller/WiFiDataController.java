package com.botmasterzzz.mobile.controller;

import com.botmasterzzz.mobile.dto.Response;
import com.botmasterzzz.mobile.dto.UserDevice;
import com.botmasterzzz.mobile.dto.UserPrincipal;
import com.botmasterzzz.mobile.exception.CustomException;
import com.botmasterzzz.mobile.service.WiFiDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class WiFiDataController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WiFiDataController.class);

    @Autowired
    private WiFiDataService wiFiDataService;

    @PreAuthorize("authenticated")
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response mobileWiFiDataCreate(@RequestBody @NotNull UserDevice userDevice) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) usernamePasswordAuthenticationToken.getPrincipal();
        userDevice.setUserId(userPrincipal.getId());
        LOGGER.info("Request to WiFi data create {} for {}", userDevice.getIpAddress(), userDevice.getUserId());
        try{
            wiFiDataService.userDeviceAdd(userDevice);
        }catch (CustomException exception){
            LOGGER.info("WiFi data create ERROR {} for {}", userDevice.getIpAddress(), userDevice.getUserId());
            return getResponseDtoError(exception.getMessage());
        }
        LOGGER.info("WiFi data created {} for {}", userDevice.getIpAddress(), userDevice.getUserId());
        return getResponseDto(userDevice);
    }

    @PreAuthorize("authenticated")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response mobileWiFiDataGetList() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) usernamePasswordAuthenticationToken.getPrincipal();
        long userId = userPrincipal.getId();
        LOGGER.info("Request to WiFi data list for {}", userId);
        List<UserDevice> userDeviceList;
        try{
            userDeviceList = wiFiDataService.getUserDeviceList(userId);
        }catch (CustomException exception){
            LOGGER.info("WiFi data list ERROR for {}", userId);
            return getResponseDtoError(exception.getMessage());
        }
        LOGGER.info("Request to WiFi data list done for {} with size {}", userId, userDeviceList.size());
        return getResponseDto(userDeviceList);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/full", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response mobileWiFiDataGetFullList() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) usernamePasswordAuthenticationToken.getPrincipal();
        long userId = userPrincipal.getId();
        LOGGER.info("Request to WiFi data list for {}", userId);
        List<UserDevice> userDeviceList;
        try{
            userDeviceList = wiFiDataService.getUserDeviceList();
        }catch (CustomException exception){
            LOGGER.info("WiFi data list ERROR for {}", userId);
            return getResponseDtoError(exception.getMessage());
        }
        LOGGER.info("Request to WiFi data list done for {} with size {}", userId, userDeviceList.size());
        return getResponseDto(userDeviceList);
    }
}
