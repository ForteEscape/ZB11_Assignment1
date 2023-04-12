package com.example.zb11_assignment;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.*;

public class WifiDataDeserializer implements JsonDeserializer<Result> {
    @Override
    public Result deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Result result = new Result(
                jsonObject.get("list_total_count").getAsInt(),
                jsonArrayToWifiData(jsonObject.get("row").getAsJsonArray())
        );
        return result;
    }

    private List<Wifi> jsonArrayToWifiData(JsonArray jsonArray){
        ArrayList<Wifi> wifiDataList = new ArrayList<>();

        for (JsonElement jsonElement : jsonArray){
            JsonObject wifiData = jsonElement.getAsJsonObject();

            wifiDataList.add(
                    new Wifi(
                            wifiData.get("X_SWIFI_MGR_NO").getAsString(),
                            wifiData.get("X_SWIFI_WRDOFC").getAsString(),
                            wifiData.get("X_SWIFI_MAIN_NM").getAsString(),
                            wifiData.get("X_SWIFI_ADRES1").getAsString(),
                            wifiData.get("X_SWIFI_ADRES2").getAsString(),
                            wifiData.get("X_SWIFI_INSTL_FLOOR").getAsString(),
                            wifiData.get("X_SWIFI_INSTL_TY").getAsString(),
                            wifiData.get("X_SWIFI_INSTL_MBY").getAsString(),
                            wifiData.get("X_SWIFI_SVC_SE").getAsString(),
                            wifiData.get("X_SWIFI_CMCWR").getAsString(),
                            wifiData.get("X_SWIFI_CNSTC_YEAR").getAsString(),
                            wifiData.get("X_SWIFI_INOUT_DOOR").getAsString(),
                            wifiData.get("X_SWIFI_REMARS3").getAsString(),
                            wifiData.get("LAT").getAsDouble(),
                            wifiData.get("LNT").getAsDouble(),
                            wifiData.get("WORK_DTTM").getAsString()
                    )
            );
        }

        return wifiDataList;
    }
}
