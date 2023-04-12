package com.example.zb11_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WifiDBManager extends DBManager{
    private String url;
    private String user;
    private String password;

    WifiDBManager(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

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

    public void insert(Wifi element){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DriverManager.getConnection(url, user, password);
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

            if (affected > 0){
                System.out.println("success");
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

            try{
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
