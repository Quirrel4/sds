package com.he.sds.ol.entity;

import lombok.Data;

@Data
public class Source {
    private String sourceId;
    private String sourceName;
    private String type;
    private String projection;
    private java.util.Map<String,Object> options;
    private String description;
}
