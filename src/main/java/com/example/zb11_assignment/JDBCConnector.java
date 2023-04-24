package com.example.zb11_assignment;

import java.sql.*;

public class JDBCConnector {

    public static Connection getConnection(){
        Connection conn = null;
        String connectionUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
        String user = "root";
        String pwd = "kk2924140";

        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void close(Connection conn){
        try{
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try{
            if (stmt != null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement pstmt){
        try{
            if (pstmt != null && !pstmt.isClosed()){
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet){
        try{
            if (resultSet != null && !resultSet.isClosed()){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
