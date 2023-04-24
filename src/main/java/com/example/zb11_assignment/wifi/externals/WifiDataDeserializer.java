package com.example.zb11_assignment.wifi.externals;

import com.example.zb11_assignment.wifi.dto.WifiDTO;
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

    private List<WifiDTO> jsonArrayToWifiData(JsonArray jsonArray){
        ArrayList<WifiDTO> wifiDataList = new ArrayList<>();

        for (JsonElement jsonElement : jsonArray){
            JsonObject wifiData = jsonElement.getAsJsonObject();

            WifiDTO wifiDTO = WifiDTO.builder()
                    .manageNo(wifiData.get("X_SWIFI_MGR_NO").getAsString())
                    .manageArea(wifiData.get("X_SWIFI_WRDOFC").getAsString())
                    .wifiName(wifiData.get("X_SWIFI_MAIN_NM").getAsString())
                    .address(wifiData.get("X_SWIFI_ADRES1").getAsString())
                    .addressDetail(wifiData.get("X_SWIFI_ADRES2").getAsString())
                    .installedFloor(wifiData.get("X_SWIFI_INSTL_FLOOR").getAsString())
                    .installType(wifiData.get("X_SWIFI_INSTL_TY").getAsString())
                    .installOrg(wifiData.get("X_SWIFI_INSTL_MBY").getAsString())
                    .serviceSeparator(wifiData.get("X_SWIFI_SVC_SE").getAsString())
                    .networkType(wifiData.get("X_SWIFI_CMCWR").getAsString())
                    .installedYear(wifiData.get("X_SWIFI_CNSTC_YEAR").getAsString())
                    .inoutDoor(wifiData.get("X_SWIFI_INOUT_DOOR").getAsString())
                    .connectEnvironment(wifiData.get("X_SWIFI_REMARS3").getAsString())
                    .lat(wifiData.get("LAT").getAsDouble())
                    .lnt(wifiData.get("LNT").getAsDouble())
                    .workDateTime(wifiData.get("WORK_DTTM").getAsString())
                    .build();

            wifiDataList.add(wifiDTO);
        }

        return wifiDataList;
    }
}
