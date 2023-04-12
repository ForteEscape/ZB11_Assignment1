package com.example.zb11_assignment;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String connectUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
        String user = "root";
        String password = "kk2924140";

        WifiDBManager wifiDBManager = new WifiDBManager(connectUrl, user, password);
        wifiDBManager.init();

        int idx = 0;
        int prevIdx = 1;

        for(int i = 1; i <= 10; i++){
            idx = i * 1000;

            String url = "http://openapi.seoul.go.kr:8088/61636356677365683439787a46536c/json/TbPublicWifiInfo/" + prevIdx + "/" + idx + "/";

            prevIdx = idx + 1;

            OkHttpClient client = new OkHttpClient();

            Request.Builder builder = new Request.Builder().url(url).get();
            Request req = builder.build();
            Response resp = client.newCall(req).execute();

            if (resp.isSuccessful()){
                ResponseBody body = resp.body();
                Gson gson = new Gson();

                if (body != null){
                    String data = "";
                    PublicWifiInfo publicWifiInfo;
                    try{
                        data = body.string();
                        publicWifiInfo = gson.fromJson(data, PublicWifiInfo.class);
                        Result result = gson.fromJson(publicWifiInfo.TbPublicWifiInfo.getAsJsonObject(), Result.class);

                        for (Wifi element : result.getWifiData()){
                            wifiDBManager.insert(element);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                        //System.out.println(data);
                    }
                }
            } else{
                System.out.println("error");
                System.err.println("error");
            }
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}