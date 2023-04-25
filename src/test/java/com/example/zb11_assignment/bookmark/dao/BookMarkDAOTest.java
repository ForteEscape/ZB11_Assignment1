package com.example.zb11_assignment.bookmark.dao;

import com.example.zb11_assignment.bookmark.domain.BookMarkResultVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;

class BookMarkDAOTest {

    @Test
    void insert() {
        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        BookMarkDTO bookMarkDTO = BookMarkDTO.builder()
                .bookmarkGroupId(5)
                .wifiName("Made in Uze")
                .registrationDate(date)
                .manageNumber("MG0006")
                .build();

        int result = BookMarkDAO.INSTANCE.insert(bookMarkDTO);

        Assertions.assertEquals(1, result);
    }

    @Test
    void delete() {
        int result = BookMarkDAO.INSTANCE.delete(2);

        Assertions.assertEquals(1, result);
    }

    @Test
    void selectAll() {
        List<BookMarkResultVO> result = BookMarkDAO.INSTANCE.selectAll();

        Assertions.assertNotNull(result);

        for (BookMarkResultVO element: result){
            System.out.println(element.toString());
        }
    }
}