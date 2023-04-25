package com.example.zb11_assignment.bookmark.dao;

import com.example.zb11_assignment.bookmark.domain.BookMarkGroupVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class BookMarkGroupDAOTest {

    @Test
    void insert() {
        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        BookMarkGroupDTO bookMarkGroupDTO = BookMarkGroupDTO.builder()
                .groupName("Cafe")
                .registrationDate(date)
                .seqNo(3)
                .modifyDate("")
                .build();

        int result = BookMarkGroupDAO.INSTANCE.insert(bookMarkGroupDTO);

        Assertions.assertEquals(1, result);
    }

    @Test
    void update() {
        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        BookMarkGroupDTO bookMarkGroupDTO = BookMarkGroupDTO.builder()
                .ID(3)
                .groupName("Cafe in company")
                .seqNo(3)
                .modifyDate(date)
                .build();

        int result = BookMarkGroupDAO.INSTANCE.update(bookMarkGroupDTO);

        Assertions.assertEquals(1, result);
    }

    @Test
    void delete() {
        int result = BookMarkGroupDAO.INSTANCE.delete(5);

        Assertions.assertNotEquals(0, result);
    }

    @Test
    void selectAll() {
        List<BookMarkGroupVO> result = BookMarkGroupDAO.INSTANCE.selectAll();

        Assertions.assertNotNull(result);

        for (BookMarkGroupVO element: result){
            System.out.println(element.toString());
        }
    }
}