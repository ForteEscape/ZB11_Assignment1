package com.example.zb11_assignment.history.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class HistoryVO {
    int uid;
    double lat;
    double lnt;
    String date;
}
