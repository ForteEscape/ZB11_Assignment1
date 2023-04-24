package com.example.zb11_assignment.history.dao;

import com.example.zb11_assignment.JDBCConnector;
import com.example.zb11_assignment.history.domain.HistoryVO;
import com.example.zb11_assignment.history.dto.HistoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum HistoryDAO {

    INSTANCE;

    public int insert(HistoryDTO historyDTO){
        int result = 0;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "insert into history (" +
                    "LAT, LNT, DATE) values(?, ?, ?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, historyDTO.getLat());
            preparedStatement.setDouble(2, historyDTO.getLnt());
            preparedStatement.setString(3, historyDTO.getDate());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
        }

        return result;
    }

    public int delete(int idx) {
        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        int result = 0;

        try{
            String sql = "delete from history where ID=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idx);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
        }

        return result;
    }

    public List<HistoryVO> selectAll(){
        List<HistoryVO> result = new ArrayList<>();

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select * from history ORDER BY ID DESC";
            preparedStatement = conn.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                HistoryVO historyVO = HistoryVO.builder()
                        .uid(rs.getInt("ID"))
                        .lat(rs.getDouble("LAT"))
                        .lnt(rs.getDouble("LNT"))
                        .date(rs.getString("DATE"))
                        .build();

                result.add(historyVO);
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
