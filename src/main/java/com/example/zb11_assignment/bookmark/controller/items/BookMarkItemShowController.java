package com.example.zb11_assignment.bookmark.controller.items;

import com.example.zb11_assignment.bookmark.dto.BookMarkResultDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookMarkItemShowController", urlPatterns = "/bookmark/items/show")
public class BookMarkItemShowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookMarkResultDTO> result = BookMarkItemService.INSTANCE.getItemList();

        req.setAttribute("itemData", result);
        req.getRequestDispatcher("/bookmark/items/show-items.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookMarkResultDTO> result = BookMarkItemService.INSTANCE.getItemList();

        req.setAttribute("itemData", result);
        req.getRequestDispatcher("/bookmark/items/show-items.jsp").forward(req, resp);
    }
}
