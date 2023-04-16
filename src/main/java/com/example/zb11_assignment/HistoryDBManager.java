package com.example.zb11_assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDBManager extends DBManager{
    @Override
    public boolean init() {
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

    public void insert(Connection connection, History element){
        PreparedStatement preparedStatement = null;

        try{
            String sql = "insert into history (" +
                    "UID, LAT, LNT, DATE) values(?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, element.getUid());
            preparedStatement.setDouble(2, element.getLat());
            preparedStatement.setDouble(3, element.getLnt());
            preparedStatement.setString(4, element.getDate());

            int affected = preparedStatement.executeUpdate();

            if (affected <= 0){
                System.out.println("update fail");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int delete(Connection connection, int idx) {
        PreparedStatement preparedStatement = null;
        int result = 0;

        try{
            String sql = "delete from history where UID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idx);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public List<History> read(Connection connection){
        List<History> historyList = new ArrayList<>();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "select * from history order by uid desc";
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int uid = resultSet.getInt("UID");
                double lat = resultSet.getDouble("LAT");
                double lnt = resultSet.getDouble("LNT");
                String date = resultSet.getString("DATE");

                historyList.add(new History(uid, lat, lnt, date));
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return historyList;
    }

    public int getCurrentUid(Connection connection){
        PreparedStatement preparedStatement = null;
        int uid = -1;

        try{
            String sql = "select UID from history order by UID DESC LIMIT 1";
            preparedStatement = connection.prepareStatement(sql);

            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                uid = result.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return uid;
    }
}
