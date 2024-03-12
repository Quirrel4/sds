package com.he.sds.vetical.entity;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;


@Data
public class SectionSource {
    String sourceId;
    String sectionId;
    Geometry[] lineSource;
    String rockId;
    String description;
}
