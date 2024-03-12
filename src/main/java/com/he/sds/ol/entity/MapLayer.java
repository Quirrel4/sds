package com.he.sds.ol.entity;

import lombok.Data;

@Data
public class MapLayer {
    private Layer layer;
    private Boolean isBinded = Boolean.FALSE;
}
