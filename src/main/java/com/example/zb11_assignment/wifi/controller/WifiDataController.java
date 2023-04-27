package com.example.zb11_assignment.wifi.controller;

import com.example.zb11_assignment.wifi.service.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "wifiDataController", urlPatterns = "/wifi/getData")
public class WifiDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentRows = WifiService.INSTANCE.chkDataExistence();

        if (currentRows == 0){
            currentRows = WifiService.INSTANCE.getDataFromAPI();
        }

        req.setAttribute("totalCnt", currentRows);
        req.getRequestDispatcher("/templates/wifi/getWifiData.jsp").forward(req, resp);
    }
}
