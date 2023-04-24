package com.example.zb11_assignment.wifi.externals;

import com.example.zb11_assignment.wifi.dto.WifiDTO;
import com.example.zb11_assignment.wifi.externals.WifiDataDeserializer;
import com.google.gson.annotations.JsonAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@JsonAdapter(WifiDataDeserializer.class)
@AllArgsConstructor
@Getter
public class Result {
    private int totalCount;
    private List<WifiDTO> wifiData;
}
