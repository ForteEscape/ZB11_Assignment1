package com.example.zb11_assignment.bookmark.controller.group;

import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookMarkGroupPrepareDeleteController", urlPatterns = "/bookmark/group/deletePrepare")
public class BookMarkGroupPrepareDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookMarkGroupId = req.getParameter("id");

        BookMarkGroupDTO result = BookMarkGroupService.INSTANCE.getGroupInfo(Integer.parseInt(bookMarkGroupId));

        req.setAttribute("id", bookMarkGroupId);
        req.setAttribute("bookmarkInfo", result);
        req.getRequestDispatcher("/templates/bookmark/group/delete-prepare.jsp").forward(req, resp);
    }
}
