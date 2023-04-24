package com.example.zb11_assignment.wifi.dao;

import com.example.zb11_assignment.wifi.domain.WifiVO;
import com.example.zb11_assignment.wifi.dto.WifiDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WifiDAOTest {

    @Test
    void insert() throws SQLException {
        Connection conn = WifiDAO.INSTANCE.getConnection();

        WifiDTO wifiDTO = WifiDTO.builder()
                .manageNo("EP000003")
                .manageArea("은평구")
                .wifiName("갈현2동주민센터")
                .address("갈현2동 연서로27길 31-6")
                .addressDetail("갈현2동 1층")
                .installedFloor("")
                .installType("7-1. 공공 - 행정")
                .installOrg("의견(자치)")
                .serviceSeparator("공공WiFi")
                .networkType("자가망_U무선망")
                .installedYear("2011")
                .inoutDoor("실내")
                .connectEnvironment("")
                .lnt(126.91592)
                .lat(37.61855)
                .workDateTime("2023-04-24 10:58:20")
                .build();

        int res = WifiDAO.INSTANCE.insert(wifiDTO, conn);
        Assertions.assertNotEquals(0, res);
    }

    @Test
    void selectAll() {
        List<WifiVO> result = WifiDAO.INSTANCE.selectAll();

        result.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    void selectOneByMGN() {
        WifiVO result = WifiDAO.INSTANCE.selectOneByMGN("---GR010008");

        Assertions.assertNotNull(result);
        System.out.println(result.toString());
    }
}