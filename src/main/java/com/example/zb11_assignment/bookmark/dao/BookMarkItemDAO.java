package com.example.zb11_assignment.bookmark.dao;

import com.example.zb11_assignment.JDBCConnector;
import com.example.zb11_assignment.bookmark.domain.BookMarkResultVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum BookMarkItemDAO {
    INSTANCE;

    public int insert(BookMarkDTO bookMarkDTO){
        int result = 0;
        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "insert into bookmark_detail (BOOKMARK_GROUP_ID, WIFI_NAME, REGIST_DATE, MNG_NO) " +
                    "values (?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, bookMarkDTO.getBookmarkGroupId());
            preparedStatement.setString(2, bookMarkDTO.getWifiName());
            preparedStatement.setString(3, bookMarkDTO.getRegistrationDate());
            preparedStatement.setString(4, bookMarkDTO.getManageNo());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
        }

        return result;
    }

    public int delete(int id){
        int result = 0;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "delete from bookmark_detail where ID = ?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
        }

        return result;
    }

    public List<BookMarkResultVO> selectAll(){
        List<BookMarkResultVO> result = new ArrayList<>();

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select B.ID, BG.BOOKMARK_NAME, B.WIFI_NAME, B.REGIST_DATE, B.MNG_NO from bookmark_detail B " +
                    "inner join bookmark_group BG on B.BOOKMARK_GROUP_ID = BG.BOOKMARK_GROUP_ID ORDER BY B.ID ASC";
            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                BookMarkResultVO bookMarkResultVO = BookMarkResultVO.builder()
                        .ID(rs.getInt("ID"))
                        .bookmarkName(rs.getString("BOOKMARK_NAME"))
                        .wifiName(rs.getString("WIFI_NAME"))
                        .registrationDate(rs.getString("REGIST_DATE"))
                        .manageNo(rs.getString("MNG_NO"))
                        .build();

                result.add(bookMarkResultVO);
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

    public BookMarkResultVO selectOne(int id){
        BookMarkResultVO result = null;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select B.ID, BG.BOOKMARK_NAME, B.WIFI_NAME, B.REGIST_DATE, B.MNG_NO from bookmark_detail B " +
                    "inner join bookmark_group BG on B.BOOKMARK_GROUP_ID = BG.BOOKMARK_GROUP_ID where B.ID=?";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                result = BookMarkResultVO.builder()
                        .ID(rs.getInt("ID"))
                        .bookmarkName(rs.getString("BOOKMARK_NAME"))
                        .wifiName(rs.getString("WIFI_NAME"))
                        .registrationDate(rs.getString("REGIST_DATE"))
                        .manageNo(rs.getString("MNG_NO"))
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

    public int checkData(BookMarkDTO bookMarkDTO){
        int result = 0;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select count(*) from bookmark_detail where BOOKMARK_GROUP_ID=? and MNG_NO=?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, bookMarkDTO.getBookmarkGroupId());
            preparedStatement.setString(2, bookMarkDTO.getManageNo());

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                result = rs.getInt(1);
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
