package com.example.zb11_assignment.bookmark.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class BookMarkGroupVO {
    private int ID;
    private String groupName;
    private int seqNo;
    private String registrationDate;
    private String modifyDate;
}
