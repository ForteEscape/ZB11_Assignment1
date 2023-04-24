package com.example.zb11_assignment.wifi.dao;

import com.example.zb11_assignment.JDBCConnector;
import com.example.zb11_assignment.wifi.domain.WifiVO;
import com.example.zb11_assignment.wifi.dto.WifiDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum WifiDAO {
    INSTANCE;

    public Connection getConnection(){
        return JDBCConnector.getConnection();
    }

    public void close(Connection conn){
        JDBCConnector.close(conn);
    }

    public int insert(WifiDTO wifiDTO, Connection conn) throws SQLException {
        PreparedStatement preparedStatement = null;

        int res = 0;

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

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, wifiDTO.getManageNo());
            preparedStatement.setString(2, wifiDTO.getManageArea());
            preparedStatement.setString(3, wifiDTO.getWifiName());
            preparedStatement.setString(4, wifiDTO.getAddress());
            preparedStatement.setString(5, wifiDTO.getAddressDetail());
            preparedStatement.setString(6, wifiDTO.getInstalledFloor());
            preparedStatement.setString(7, wifiDTO.getInstallType());
            preparedStatement.setString(8, wifiDTO.getInstallOrg());
            preparedStatement.setString(9, wifiDTO.getServiceSeparator());
            preparedStatement.setString(10, wifiDTO.getNetworkType());
            preparedStatement.setString(11, wifiDTO.getInstalledYear());
            preparedStatement.setString(12, wifiDTO.getInoutDoor());
            preparedStatement.setString(13, wifiDTO.getConnectEnvironment());
            preparedStatement.setDouble(14, wifiDTO.getLat());
            preparedStatement.setDouble(15, wifiDTO.getLnt());
            preparedStatement.setString(16, wifiDTO.getWorkDateTime());

            res = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCConnector.close(preparedStatement);
        }

        return res;
    }

    public List<WifiVO> selectAll(){
        List<WifiVO> resultList = new ArrayList<>();

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select * from wifi_detail";
            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                WifiVO wifiVO = WifiVO.builder()
                        .manageNo(rs.getString("X_SWIFI_MGR_NO"))
                        .manageArea(rs.getString("X_SWIFI_WRDOFC"))
                        .wifiName(rs.getString("X_SWIFI_MAIN_NM"))
                        .address(rs.getString("X_SWIFI_ADRES1"))
                        .addressDetail(rs.getString("X_SWIFI_ADRES2"))
                        .installedFloor(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .installType(rs.getString("X_SWIFI_INSTL_TY"))
                        .installOrg(rs.getString("X_SWIFI_INSTL_MBY"))
                        .serviceSeparator(rs.getString("X_SWIFI_SVC_SE"))
                        .networkType(rs.getString("X_SWIFI_CMCWR"))
                        .installedYear(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .inoutDoor(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .connectEnvironment(rs.getString("X_SWIFI_REMARS3"))
                        .lat(rs.getDouble("LAT"))
                        .lnt(rs.getDouble("LNT"))
                        .workDateTime(rs.getString("WORK_DTTM"))
                        .build();

                resultList.add(wifiVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
            JDBCConnector.close(rs);
        }

        return resultList;
    }

    public WifiVO selectOneByMGN(String manageNo){
        WifiVO result = null;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select * from wifi_detail where X_SWIFI_MGR_NO = ?";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, manageNo);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                result = WifiVO.builder()
                        .manageNo(rs.getString("X_SWIFI_MGR_NO"))
                        .manageArea(rs.getString("X_SWIFI_WRDOFC"))
                        .wifiName(rs.getString("X_SWIFI_MAIN_NM"))
                        .address(rs.getString("X_SWIFI_ADRES1"))
                        .addressDetail(rs.getString("X_SWIFI_ADRES2"))
                        .installedFloor(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .installType(rs.getString("X_SWIFI_INSTL_TY"))
                        .installOrg(rs.getString("X_SWIFI_INSTL_MBY"))
                        .serviceSeparator(rs.getString("X_SWIFI_SVC_SE"))
                        .networkType(rs.getString("X_SWIFI_CMCWR"))
                        .installedYear(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .inoutDoor(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .connectEnvironment(rs.getString("X_SWIFI_REMARS3"))
                        .lat(rs.getDouble("LAT"))
                        .lnt(rs.getDouble("LNT"))
                        .workDateTime(rs.getString("WORK_DTTM"))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
            JDBCConnector.close(rs);
        }

        return result;
    }
}
