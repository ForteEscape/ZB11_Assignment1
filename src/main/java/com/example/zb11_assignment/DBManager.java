package com.example.zb11_assignment;

import java.sql.Connection;
import java.util.*;

public abstract class DBManager {
    public abstract boolean init();
    public abstract void insert(Connection connection, Wifi element);
    public abstract List<Wifi> read(Connection connection);
}
