package com.example.zb11_assignment.wifi.externals;

import com.example.zb11_assignment.wifi.domain.WifiVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class WifiTotalData implements Comparable<WifiTotalData> {
    private double distance;
    private WifiVO wifiData;

    @Override
    public int compareTo(@NotNull WifiTotalData o) {
        return Double.compare(this.distance, o.distance);
    }
}
