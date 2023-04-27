package com.example.zb11_assignment.bookmark.controller.items;

import com.example.zb11_assignment.bookmark.service.BookMarkItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookMarkItemDeleteController", urlPatterns = "/bookmark/items/delete")
public class BookMarkItemDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        BookMarkItemService.INSTANCE.deleteItem(Integer.parseInt(id));
        req.getRequestDispatcher("/templates/bookmark/items/delete-items-success.jsp").forward(req, resp);
    }
}
