package com.example.zb11_assignment.wifi.controller;

import com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO;
import com.example.zb11_assignment.bookmark.service.BookMarkGroupService;
import com.example.zb11_assignment.wifi.dto.WifiDTO;
import com.example.zb11_assignment.wifi.service.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "wifiDetailController", urlPatterns = "/wifi/detail")
public class WifiDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manageNo = req.getParameter("manageNo");
        String dist = req.getParameter("distance");

        List<BookMarkGroupDTO> bookMarkGroup = BookMarkGroupService.INSTANCE.getBookMarkGroup();
        WifiDTO result = WifiService.INSTANCE.getWifiData(manageNo);

        req.setAttribute("result", result);
        req.setAttribute("dist", dist);
        req.setAttribute("bookMarkGroup", bookMarkGroup);
        req.getRequestDispatcher("/templates/wifi/wifiDetail.jsp").forward(req, resp);
    }
}
