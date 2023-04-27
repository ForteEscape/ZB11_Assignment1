package com.example.zb11_assignment.bookmark.controller.items;

import com.example.zb11_assignment.bookmark.dao.BookMarkItemDAO;
import com.example.zb11_assignment.bookmark.dto.BookMarkDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

@WebServlet(name = "bookMarkAddController", urlPatterns = "/bookmark/items/add")
public class BookMarkItemAddController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        String bookMarkGroupId = req.getParameter("bookmark");
        String wifiName = req.getParameter("wifiName");
        String manageNo = req.getParameter("mngNo");

        BookMarkDTO bookMarkDTO = BookMarkDTO.builder()
                .bookmarkGroupId(Integer.parseInt(bookMarkGroupId))
                .wifiName(wifiName)
                .registrationDate(date)
                .manageNo(manageNo)
                .build();

        if (BookMarkItemService.INSTANCE.checkExists(bookMarkDTO)){
            req.getRequestDispatcher("/templates/bookmark/items/items-error.jsp").forward(req, resp);
        } else{
            BookMarkItemService.INSTANCE.addBookMark(bookMarkDTO);
            req.getRequestDispatcher("/templates/bookmark/items/items-success.jsp").forward(req, resp);
        }
    }
}
