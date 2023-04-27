package com.example.zb11_assignment.bookmark.controller.group;

import com.example.zb11_assignment.bookmark.service.BookMarkGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookMarkGroupDeleteController", urlPatterns = "/bookmark/group/delete")
public class BookMarkGroupDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        BookMarkGroupService.INSTANCE.deleteGroupInfo(Integer.parseInt(id));
        req.getRequestDispatcher("/templates/bookmark/group/delete-group-success.jsp").forward(req, resp);
    }
}
