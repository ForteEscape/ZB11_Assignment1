package com.example.zb11_assignment.bookmark.controller.group;

import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

@WebServlet(name = "bookMarkGroupModifyController", urlPatterns = "/bookmark/group/modify")
public class BookMarkGroupModifyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String bookmarkName = req.getParameter("bookmarkName");
        String seqNo = req.getParameter("seqNo");
        String id = req.getParameter("id");

        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        BookMarkGroupDTO bookMarkGroupDTO = BookMarkGroupDTO.builder()
                .ID(Integer.parseInt(id))
                .groupName(bookmarkName)
                .seqNo(Integer.parseInt(seqNo))
                .modifyDate(date)
                .build();

        BookMarkGroupService.INSTANCE.updateGroupInfo(bookMarkGroupDTO);

        req.getRequestDispatcher("/templates/bookmark/group/modify-group-success.jsp").forward(req, resp);
    }
}
