package com.example.zb11_assignment.bookmark.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class BookMarkResultVO {
    private int ID;
    private String bookmarkName;
    private String wifiName;
    private String registrationDate;
}
