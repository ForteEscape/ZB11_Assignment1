package com.example.zb11_assignment.history.dao;

import com.example.zb11_assignment.history.domain.HistoryVO;
import com.example.zb11_assignment.history.dto.HistoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryDAOTest {

    @Test
    void insert() {
        HistoryDTO historyDTO = HistoryDTO.builder()
                .lnt(37.5544069)
                .lat(128.8998696)
                .date("2022-05-08T02:49:38")
                .build();

        int result = HistoryDAO.INSTANCE.insert(historyDTO);

        Assertions.assertNotEquals(0, 1);
    }

    @Test
    void delete() {
        int result = HistoryDAO.INSTANCE.delete(1);

        Assertions.assertNotEquals(0, 1);
    }

    @Test
    void selectAll() {
        List<HistoryVO> resultList = HistoryDAO.INSTANCE.selectAll();

        resultList.forEach(i -> System.out.println(i.toString()));
    }
}