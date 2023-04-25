package com.example.zb11_assignment.bookmark.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookMarkDTO {
    private int ID;
    private int bookmarkGroupId;
    private String wifiName;
    private String registrationDate;
    private String manageNumber;
}
