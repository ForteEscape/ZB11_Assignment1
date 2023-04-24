package com.example.zb11_assignment.wifi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WifiDTO {
    private String manageNo;
    private String manageArea;
    private String wifiName;
    private String address;
    private String addressDetail;
    private String installedFloor;
    private String installType;
    private String installOrg;
    private String serviceSeparator;
    private String networkType;
    private String installedYear;
    private String inoutDoor;
    private String connectEnvironment;
    private double lnt;
    private double lat;
    private String workDateTime;
}
