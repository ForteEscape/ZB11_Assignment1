package com.example.zb11_assignment.history.controller;

import com.example.zb11_assignment.history.dto.HistoryDTO;
import com.example.zb11_assignment.history.service.HistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "historyShowController", urlPatterns = "/history/show")
public class HistoryShowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HistoryDTO> result = HistoryService.INSTANCE.getHistory();

        req.setAttribute("result", result);
        req.getRequestDispatcher("/templates/history/history.jsp").forward(req, resp);
    }
}
