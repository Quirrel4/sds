package com.he.sds.ol.entity;

import lombok.Data;

@Data
public class TestStation {
    private Integer stationId;
    private String stationName;
    private StationStatus stationStatus;
}
