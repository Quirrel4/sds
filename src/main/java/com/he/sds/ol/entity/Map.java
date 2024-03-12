package com.he.sds.ol.entity;

import lombok.Data;

@Data
public class Map {
    private String mapId;
    private String mapName;
    private java.util.Map<String,Object> view;
    private String[] controls;
    private Integer pixelRatio;
    private String[] interactions;
    private String[] layers;
    private Boolean logo = Boolean.FALSE;
    private String[] overlays;
    private String description;
}
