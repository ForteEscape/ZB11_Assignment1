package com.example.zb11_assignment.wifi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WifiVO {
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
