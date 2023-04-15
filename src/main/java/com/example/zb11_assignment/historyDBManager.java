package com.example.zb11_assignment;

import java.sql.Connection;
import java.util.List;

public class historyDBManager extends DBManager{
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

    @Override
    public void insert(Connection connection, Wifi element) {

    }

    @Override
    public List<Wifi> read(Connection connection) {
        return null;
    }

    public void delete(Connection connection){

    }
}
