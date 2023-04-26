package com.example.zb11_assignment.bookmark.dao;

import com.example.zb11_assignment.bookmark.domain.BookMarkResultVO;
import com.example.zb11_assignment.bookmark.dto.BookMarkDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;

class BookMarkItemDAOTest {

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
                .build();

        int result = BookMarkItemDAO.INSTANCE.insert(bookMarkDTO);

        Assertions.assertEquals(1, result);
    }

    @Test
    void delete() {
        int result = BookMarkItemDAO.INSTANCE.delete(2);

        Assertions.assertEquals(1, result);
    }

    @Test
    void selectAll() {
        List<BookMarkResultVO> result = BookMarkItemDAO.INSTANCE.selectAll();

        Assertions.assertNotNull(result);

        for (BookMarkResultVO element: result){
            System.out.println(element.toString());
        }
    }
}