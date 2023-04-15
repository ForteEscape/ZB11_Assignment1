package com.example.zb11_assignment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class WifiTotalData implements Comparable<WifiTotalData> {
    private double distance;
    private Wifi wifiData;

    @Override
    public int compareTo(@NotNull WifiTotalData o) {
        return Double.compare(this.distance, o.distance);
    }
}
