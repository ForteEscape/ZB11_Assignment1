package com.example.zb11_assignment.history.controller;

import com.example.zb11_assignment.history.service.HistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "historyDeleteController", urlPatterns = "/history/delete")
public class HistoryDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");

        HistoryService.INSTANCE.deleteHistory(Integer.parseInt(idx));
        req.getRequestDispatcher("/history/show").forward(req, resp);
    }
}
