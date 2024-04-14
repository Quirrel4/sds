package com.he.sds.vetical.entity;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;


@Data
public abstract class SectionSource {
    String sourceId;
    String sectionId;
    Geometry[] lineSource;
    String materialId;
    String description;
}
