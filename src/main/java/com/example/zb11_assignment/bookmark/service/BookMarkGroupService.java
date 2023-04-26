package com.example.zb11_assignment.bookmark.service;

import com.example.zb11_assignment.bookmark.dao.BookMarkGroupDAO;
import com.example.zb11_assignment.bookmark.domain.BookMarkGroupVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;

import java.util.ArrayList;
import java.util.List;

public enum BookMarkGroupService {
    INSTANCE;

    public List<BookMarkGroupDTO> getBookMarkGroup(){
        List<BookMarkGroupVO> list = BookMarkGroupDAO.INSTANCE.selectAll();
        List<BookMarkGroupDTO> result = new ArrayList<>();

        for (BookMarkGroupVO element: list){
            BookMarkGroupDTO bookMarkGroupDTO = BookMarkGroupDTO.builder()
                    .ID(element.getID())
                    .seqNo(element.getSeqNo())
                    .registrationDate(element.getRegistrationDate())
                    .modifyDate(element.getModifyDate())
                    .groupName(element.getGroupName())
                    .build();

            result.add(bookMarkGroupDTO);
        }

        return result;
    }

    public BookMarkGroupDTO getGroupInfo(int id){
        BookMarkGroupDTO result;
        BookMarkGroupVO data = BookMarkGroupDAO.INSTANCE.select(id);

        result = BookMarkGroupDTO.builder()
                .ID(data.getID())
                .seqNo(data.getSeqNo())
                .groupName(data.getGroupName())
                .registrationDate(data.getRegistrationDate())
                .modifyDate(data.getModifyDate())
                .build();

        return result;
    }

    public int deleteGroupInfo(int id){
        int result = 0;

        result = BookMarkGroupDAO.INSTANCE.delete(id);
        return result;
    }

    public int addGroupInfo(BookMarkGroupDTO bookMarkGroupDTO){
        return BookMarkGroupDAO.INSTANCE.insert(bookMarkGroupDTO);
    }

    public int updateGroupInfo(BookMarkGroupDTO bookMarkGroupDTO){
        return BookMarkGroupDAO.INSTANCE.update(bookMarkGroupDTO);
    }
}
