package com.example.zb11_assignment.bookmark.controller.group;

import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookMarkShowController", urlPatterns = "/bookmark/group/show")
public class BookMarkGroupShowController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookMarkGroupDTO> result = BookMarkGroupService.INSTANCE.getBookMarkGroup();

        req.setAttribute("bookMarkGroup", result);
        req.getRequestDispatcher("/templates/bookmark/group/group-show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookMarkGroupDTO> result = BookMarkGroupService.INSTANCE.getBookMarkGroup();

        req.setAttribute("bookMarkGroup", result);
        req.getRequestDispatcher("/templates/bookmark/group/group-show.jsp").forward(req, resp);
    }
}
