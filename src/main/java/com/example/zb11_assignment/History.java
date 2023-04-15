package com.example.zb11_assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class History {
    int uid;
    double lat;
    double lnt;
    java.sql.Date date;
}
