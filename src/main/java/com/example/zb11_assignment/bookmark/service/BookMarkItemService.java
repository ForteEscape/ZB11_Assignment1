package com.example.zb11_assignment.bookmark.service;

import com.example.zb11_assignment.bookmark.dao.BookMarkItemDAO;
import com.example.zb11_assignment.bookmark.domain.BookMarkResultVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkDTO;
import com.example.zb11_assignment.bookmark.dto.BookMarkResultDTO;

import java.util.ArrayList;
import java.util.List;

public enum BookMarkItemService {
    INSTANCE;

    public List<BookMarkResultDTO> getItemList(){
        List<BookMarkResultVO> list = BookMarkItemDAO.INSTANCE.selectAll();
        List<BookMarkResultDTO> result = new ArrayList<>();

        for(BookMarkResultVO element: list){
            BookMarkResultDTO bookMarkResultDTO = BookMarkResultDTO.builder()
                    .ID(element.getID())
                    .bookmarkName(element.getBookmarkName())
                    .wifiName(element.getWifiName())
                    .registrationDate(element.getRegistrationDate())
                    .manageNo(element.getManageNo())
                    .build();

            result.add(bookMarkResultDTO);
        }

        return result;
    }

    public BookMarkResultDTO getItem(int id){
        BookMarkResultVO data = BookMarkItemDAO.INSTANCE.selectOne(id);

        BookMarkResultDTO result = BookMarkResultDTO.builder()
                .ID(data.getID())
                .bookmarkName(data.getBookmarkName())
                .registrationDate(data.getRegistrationDate())
                .wifiName(data.getWifiName())
                .manageNo(data.getManageNo())
                .build();

        return result;
    }

    public boolean checkExists(BookMarkDTO element){
        int result = BookMarkItemDAO.INSTANCE.checkData(element);

        return result != 0;
    }

    public int addBookMark(BookMarkDTO element){
        return BookMarkItemDAO.INSTANCE.insert(element);
    }

    public int deleteItem(int id){
        return BookMarkItemDAO.INSTANCE.delete(id);
    }
}
