package com.example.zb11_assignment.bookmark.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookMarkResultDTO {
    private int ID;
    private String bookmarkName;
    private String wifiName;
    private String registrationDate;
}
