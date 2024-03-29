package com.example.zb11_assignment.history.service;

import com.example.zb11_assignment.history.dao.HistoryDAO;
import com.example.zb11_assignment.history.domain.HistoryVO;
import com.example.zb11_assignment.history.dto.HistoryDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.sql.Timestamp;

public enum HistoryService {
    INSTANCE;

    public void addRecord(double lnt, double lat){
        Timestamp dateTime = Timestamp.valueOf(java.time.LocalDateTime.now());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        StringTokenizer st = new StringTokenizer(sdf.format(dateTime));
        String date = st.nextToken() + "T" + st.nextToken();

        HistoryDTO historyDTO = HistoryDTO.builder()
                .lnt(lnt)
                .lat(lat)
                .date(date)
                .build();

        HistoryDAO.INSTANCE.insert(historyDTO);
    }

    public List<HistoryDTO> getHistory(){
        List<HistoryVO> list = HistoryDAO.INSTANCE.selectAll();
        List<HistoryDTO> result = new ArrayList<>();

        for (HistoryVO element: list){
            HistoryDTO historyDTO = HistoryDTO.builder()
                    .uid(element.getUid())
                    .lat(element.getLat())
                    .lnt(element.getLnt())
                    .date(element.getDate())
                    .build();

            result.add(historyDTO);
        }

        return result;
    }

    public void deleteHistory(int idx){
        HistoryDAO.INSTANCE.delete(idx);
    }
}
