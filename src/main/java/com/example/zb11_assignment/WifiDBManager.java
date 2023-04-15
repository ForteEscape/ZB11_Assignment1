package com.example.zb11_assignment;

import java.sql.*;
import java.util.*;

public class WifiDBManager extends DBManager{
    public boolean init(){
        try{
            Class<?> dbDriver = Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("driver connected");

            return true;
        } catch(ClassNotFoundException e){
            System.out.println("Driver not connected");
            e.printStackTrace();

            return false;
        }
    }

    public void insert(Connection connection, Wifi element){
        PreparedStatement preparedStatement = null;

        try{
            String sql = "insert into wifi_detail (" +
                    "X_SWIFI_MGR_NO," +
                    "X_SWIFI_WRDOFC," +
                    "X_SWIFI_MAIN_NM," +
                    "X_SWIFI_ADRES1," +
                    "X_SWIFI_ADRES2," +
                    "X_SWIFI_INSTL_FLOOR," +
                    "X_SWIFI_INSTL_TY," +
                    "X_SWIFI_INSTL_MBY," +
                    "X_SWIFI_SVC_SE," +
                    "X_SWIFI_CMCWR," +
                    "X_SWIFI_CNSTC_YEAR," +
                    "X_SWIFI_INOUT_DOOR," +
                    "X_SWIFI_REMARS3," +
                    "LAT," +
                    "LNT," +
                    "WORK_DTTM" +
                    ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, element.getManageNo());
            preparedStatement.setString(2, element.getManageArea());
            preparedStatement.setString(3, element.getWifiName());
            preparedStatement.setString(4, element.getAddress());
            preparedStatement.setString(5, element.getAddressDetail());
            preparedStatement.setString(6, element.getInstalledFloor());
            preparedStatement.setString(7, element.getInstallType());
            preparedStatement.setString(8, element.getInstallOrg());
            preparedStatement.setString(9, element.getServiceSeparator());
            preparedStatement.setString(10, element.getNetworkType());
            preparedStatement.setString(11, element.getInstalledYear());
            preparedStatement.setString(12, element.getInoutDoor());
            preparedStatement.setString(13, element.getConnectEnvironment());
            preparedStatement.setDouble(14, element.getLat());
            preparedStatement.setDouble(15, element.getLnt());
            preparedStatement.setString(16, element.getWorkDateTime());

            int affected = preparedStatement.executeUpdate();

            if (affected == 0){
                System.out.println("error occur");
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Wifi> read(Connection connection){
        List<Wifi> wifiDataList = new ArrayList<>(20000);
        Statement statement = null;

        try{
            String sql = "select * from wifi_detail";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String manageNo = resultSet.getString("X_SWIFI_MGR_NO");
                String manageArea = resultSet.getString("X_SWIFI_WRDOFC");
                String wifiName = resultSet.getString("X_SWIFI_MAIN_NM");
                String address = resultSet.getString("X_SWIFI_ADRES1");
                String addressDetail = resultSet.getString("X_SWIFI_ADRES2");
                String installedFloor = resultSet.getString("X_SWIFI_INSTL_FLOOR");
                String installType = resultSet.getString("X_SWIFI_INSTL_TY");
                String installOrg = resultSet.getString("X_SWIFI_INSTL_MBY");
                String serviceSeparator = resultSet.getString("X_SWIFI_SVC_SE");
                String networkType = resultSet.getString("X_SWIFI_CMCWR");
                String installedYear = resultSet.getString("X_SWIFI_CNSTC_YEAR");
                String inoutDoor = resultSet.getString("X_SWIFI_INOUT_DOOR");
                String connectEnvironment = resultSet.getString("X_SWIFI_REMARS3");
                double lat = resultSet.getDouble("LAT");
                double lnt = resultSet.getDouble("LNT");
                String workDateTime = resultSet.getString("WORK_DTTM");

                wifiDataList.add(new Wifi(
                        manageNo,
                        manageArea,
                        wifiName,
                        address,
                        addressDetail,
                        installedFloor,
                        installType,
                        installOrg,
                        serviceSeparator,
                        networkType,
                        installedYear,
                        inoutDoor,
                        connectEnvironment,
                        lat,
                        lnt,
                        workDateTime
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("dosent't work");
        } finally {
            try{
                if (statement != null && !statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return wifiDataList;
    }
}
