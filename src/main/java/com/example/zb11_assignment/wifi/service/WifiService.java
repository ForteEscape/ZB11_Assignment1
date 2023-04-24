package com.example.zb11_assignment.wifi.service;

import com.example.zb11_assignment.wifi.dao.WifiDAO;
import com.example.zb11_assignment.wifi.domain.WifiVO;
import com.example.zb11_assignment.wifi.dto.WifiDTO;
import com.example.zb11_assignment.wifi.externals.PublicWifiInfo;
import com.example.zb11_assignment.wifi.externals.Result;
import com.example.zb11_assignment.wifi.externals.WifiTotalData;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public enum WifiService {
    INSTANCE;

    public int getDataFromAPI() throws IOException {
        int idx = 0;
        int prevIdx = 1;
        int totalCnt = 0;

        for(int i = 1; i <= 24; i++){
            idx = i * 1000;

            String url = "http://openapi.seoul.go.kr:8088/61636356677365683439787a46536c/json/TbPublicWifiInfo/" + prevIdx + "/" + idx + "/";

            OkHttpClient client = new OkHttpClient();

            Request.Builder builder = new Request.Builder().url(url).get();
            Request req = builder.build();
            Response resp = client.newCall(req).execute();

            if (resp.isSuccessful()){
                ResponseBody body = resp.body();
                Gson gson = new Gson();

                if (body != null){
                    PublicWifiInfo publicWifiInfo;

                    try{
                        publicWifiInfo = gson.fromJson(body.string(), PublicWifiInfo.class);
                        Result result = gson.fromJson(
                                publicWifiInfo.getTbPublicWifiInfo().getAsJsonObject(),
                                Result.class);

                        Connection conn = WifiDAO.INSTANCE.getConnection();
                        for(WifiDTO element: result.getWifiData()){
                            WifiDAO.INSTANCE.insert(element, conn);
                            totalCnt++;
                        }
                        WifiDAO.INSTANCE.close(conn);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            prevIdx = idx + 1;

        }

        return totalCnt;
    }

    public WifiDTO getWifiData(String manageNo){
        WifiDTO result;
        WifiVO wifiVO = WifiDAO.INSTANCE.selectOneByMGN(manageNo);

        result = WifiDTO.builder()
                .manageNo(wifiVO.getManageNo())
                .manageArea(wifiVO.getManageArea())
                .wifiName(wifiVO.getWifiName())
                .address(wifiVO.getAddress())
                .addressDetail(wifiVO.getAddressDetail())
                .installedFloor(wifiVO.getInstalledFloor())
                .installType(wifiVO.getInstallType())
                .installOrg(wifiVO.getInstallOrg())
                .serviceSeparator(wifiVO.getServiceSeparator())
                .networkType(wifiVO.getNetworkType())
                .installedYear(wifiVO.getInstalledYear())
                .inoutDoor(wifiVO.getInoutDoor())
                .connectEnvironment(wifiVO.getConnectEnvironment())
                .lat(wifiVO.getLat())
                .lnt(wifiVO.getLnt())
                .workDateTime(wifiVO.getWorkDateTime())
                .build();

        return result;
    }

    public List<WifiTotalData> getNearWifi(double lnt, double lat){
        List<WifiVO> list = WifiDAO.INSTANCE.selectAll();
        PriorityQueue<WifiTotalData> pq = new PriorityQueue<>();

        for (WifiVO element: list){
            double distance = getDist(lat, lnt, element.getLnt(), element.getLat());
            distance = (Math.round(distance * 10000.0)) / 10000.0;

            pq.offer(new WifiTotalData(distance, element));
        }

        List<WifiTotalData> resultList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            if (pq.isEmpty()) break;

            resultList.add(pq.poll());
        }

        return resultList;
    }

    private double getDist(double lat1, double lnt1, double lat2, double lnt2){
        double theta = lnt1 - lnt2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return dist * 1.609344;
    }

    private double deg2rad(double deg){
        return deg * Math.PI / 180.0;
    }

    private double rad2deg(double rad){
        return rad * 180 / Math.PI;
    }
}
