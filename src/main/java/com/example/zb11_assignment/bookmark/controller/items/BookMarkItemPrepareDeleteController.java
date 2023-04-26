package com.example.zb11_assignment.bookmark.controller.items;

import com.example.zb11_assignment.bookmark.dto.BookMarkResultDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookMarkItemPrepareDeleteController", urlPatterns = "/bookmark/items/deletePrepare")
public class BookMarkItemPrepareDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookMarkId = req.getParameter("id");

        BookMarkResultDTO result = BookMarkItemService.INSTANCE.getItem(Integer.parseInt(bookMarkId));

        req.setAttribute("itemData", result);
        req.getRequestDispatcher("/bookmark/items/delete-prepare.jsp").forward(req, resp);
    }
}
