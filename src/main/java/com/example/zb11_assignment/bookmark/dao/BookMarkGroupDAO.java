package com.example.zb11_assignment.bookmark.dao;

import com.example.zb11_assignment.JDBCConnector;
import com.example.zb11_assignment.bookmark.domain.BookMarkGroupVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum BookMarkGroupDAO {
    INSTANCE;

    public int insert(BookMarkGroupDTO bookMarkGroupDTO){
        int result = 0;

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "insert into bookmark_group(BOOKMARK_NAME, SEQ_NUM, REGIST_DATE, MODIFY_DATE)" +
                    "values(?, ?, ?, ?)";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, bookMarkGroupDTO.getGroupName());
            preparedStatement.setInt(2, bookMarkGroupDTO.getSeqNo());
            preparedStatement.setString(3, bookMarkGroupDTO.getRegistrationDate());
            preparedStatement.setString(4, bookMarkGroupDTO.getModifyDate());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCConnector.close(conn);
            JDBCConnector.close(preparedStatement);
        }

        return result;
    }

    public int update(BookMarkGroupDTO bookMarkGroupDTO){
        int result = 0;
        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "update bookmark_group " +
                    "set BOOKMARK_NAME = ?, SEQ_NUM = ?, MODIFY_DATE = ? " +
                    "where BOOKMARK_GROUP_ID = ?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, bookMarkGroupDTO.getGroupName());
            preparedStatement.setInt(2, bookMarkGroupDTO.getSeqNo());
            preparedStatement.setString(3, bookMarkGroupDTO.getModifyDate());
            preparedStatement.setInt(4, bookMarkGroupDTO.getID());

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
            String sql = "delete from bookmark_group where BOOKMARK_GROUP_ID=?";
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

    public List<BookMarkGroupVO> selectAll(){
        List<BookMarkGroupVO> result = new ArrayList<>();

        Connection conn = JDBCConnector.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            String sql = "select * from bookmark_group ORDER BY SEQ_NUM ASC";

            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                BookMarkGroupVO bookMarkGroupVO = BookMarkGroupVO.builder()
                        .ID(rs.getInt("BOOKMARK_GROUP_ID"))
                        .groupName(rs.getString("BOOKMARK_NAME"))
                        .seqNo(rs.getInt("SEQ_NUM"))
                        .registrationDate(rs.getString("REGIST_DATE"))
                        .modifyDate(rs.getString("MODIFY_DATE"))
                        .build();

                result.add(bookMarkGroupVO);
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
