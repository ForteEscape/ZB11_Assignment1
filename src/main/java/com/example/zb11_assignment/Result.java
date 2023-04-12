package com.example.zb11_assignment;

import com.google.gson.annotations.JsonAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@JsonAdapter(WifiDataDeserializer.class)
@AllArgsConstructor
@Getter
public class Result {
    private int totalCount;
    private List<Wifi> wifiData;
}
