package com.example.zb11_assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Wifi {
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
    private double lat;
    private double lnt;
    private String workDateTime;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.getManageNo()).append("\n");
        sb.append(this.getManageArea()).append("\n");
        sb.append(this.wifiName).append("\n");
        sb.append(this.address).append("\n");
        sb.append(this.addressDetail).append("\n");
        sb.append(this.installedFloor).append("\n");
        sb.append(this.installType).append("\n");
        sb.append(this.installOrg).append("\n");
        sb.append(this.serviceSeparator).append("\n");
        sb.append(this.networkType).append("\n");
        sb.append(this.installedYear).append("\n");
        sb.append(this.inoutDoor).append("\n");
        sb.append(this.connectEnvironment).append("\n");
        sb.append(this.lat).append("\n");
        sb.append(this.lnt).append("\n");
        sb.append(this.workDateTime).append("\n");

        return sb.toString();
    }
}
