package com.example.zb11_assignment.wifi.controller;

import com.example.zb11_assignment.wifi.dto.WifiDTO;
import com.example.zb11_assignment.wifi.service.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "wifiDetailController", urlPatterns = "/wifi/detail")
public class WifiDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manageNo = req.getParameter("manageNo");
        String dist = req.getParameter("distance");

        WifiDTO result = WifiService.INSTANCE.getWifiData(manageNo);

        req.setAttribute("result", result);
        req.setAttribute("dist", dist);
        req.getRequestDispatcher("/wifi/wifiDetail.jsp").forward(req, resp);
    }
}
