package com.example.zb11_assignment.history.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HistoryDTO {
    int uid;
    double lat;
    double lnt;
    String date;
}
