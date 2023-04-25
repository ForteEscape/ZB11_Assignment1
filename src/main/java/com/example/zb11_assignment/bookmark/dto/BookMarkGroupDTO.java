package com.example.zb11_assignment.bookmark.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookMarkGroupDTO {
    private int ID;
    private String groupName;
    private int seqNo;
    private String registrationDate;
    private String modifyDate;
}
