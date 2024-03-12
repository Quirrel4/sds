package com.he.sds.ol.entity;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;

@Data
public class SampleLine {
    String lineId;
    String layerId;
    String lineNamel;
    Geometry lineSource;
    String description;
}
