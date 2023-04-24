package com.example.zb11_assignment.wifi.controller;

import com.example.zb11_assignment.history.service.HistoryService;
import com.example.zb11_assignment.wifi.externals.WifiTotalData;
import com.example.zb11_assignment.wifi.service.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "locationController", urlPatterns = "/wifi/calcLocation")
public class LocationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lntParam = req.getParameter("LNT");
        String latParam = req.getParameter("LAT");

        if (lntParam == null || latParam == null){
            return;
        }

        double lnt = Double.parseDouble(lntParam);
        double lat = Double.parseDouble(latParam);

        List<WifiTotalData> result = WifiService.INSTANCE.getNearWifi(lnt, lat);
        HistoryService.INSTANCE.addRecord(lnt, lat);

        req.setAttribute("result", result);
        req.getRequestDispatcher("../index.jsp").forward(req, resp);
    }
}
