package com.example.zb11_assignment;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String connectUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
        String user = "root";
        String password = "kk2924140";

        WifiDBManager wifiDBManager = new WifiDBManager();
        wifiDBManager.init();

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
                        Result result = gson.fromJson(publicWifiInfo.TbPublicWifiInfo.getAsJsonObject(), Result.class);

                        Connection connection = DriverManager.getConnection(connectUrl, user, password);
                        System.out.println("connection opened");

                        for (Wifi element : result.getWifiData()){
                            totalCnt++;
                            wifiDBManager.insert(connection, element);
                        }
                        System.out.println(prevIdx + " to " + idx + " data inserted");

                        try{
                            if (connection != null && !connection.isClosed()){
                                connection.close();
                            }
                            System.out.println("connection closed");
                        } catch (SQLException e) {
                            e.printStackTrace();
                            break;
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } else{
                System.err.println("error");
            }

            prevIdx = idx + 1;
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 style=\"text-align: center\">" + totalCnt + "개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>");
        out.println("<div style=\"text-align: center\">");
        out.println("<a href=http://localhost:8080/ZB11_assignment_war_exploded/> 홈으로 가기</a>");
        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}