package com.example.zb11_assignment.wifi.dao;

import com.example.zb11_assignment.JDBCConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class JDBCConnectorTest {

    @Test
    void getConnection() {
        Connection conn = JDBCConnector.getConnection();

        Assertions.assertNotNull(conn);
    }
}