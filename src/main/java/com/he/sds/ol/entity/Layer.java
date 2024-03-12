package com.he.sds.ol.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Layer {
    private String layerId;
    private String layerName;
    private String aliasName;
    private Double opacity = 1.0;
    private String source;
    private Boolean visible = Boolean.TRUE;
    private BigDecimal[] extent;
    private Integer zIndex = 0;
    private BigDecimal maxResolution;
    private BigDecimal minResolution;
    private String projection;
    private String type;
    private java.util.Map<String,Object> options;
    private String description;

    public String[] PossibleSourceType(){
        String[] sourceTypeArray = null;
        switch (this.getType()){
            case "ol.layer.Tile":
                sourceTypeArray = new String[]{
                        "ol.source.TileSuperMapRest",
                        "ol.source.WMTS",
                        "ol.source.TileArcGISRest"
                };
                break;
            case "ol.layer.Image":
                sourceTypeArray = new String[]{"ol.source.Image"};
                break;
            case "ol.layer.Vector":
            case "ol.layer.Heatmap":
                sourceTypeArray = new String[]{
                        "ol.source.Vector",
                        "ol.supermap.FeatureService",
                        "arcgis.FeatureService"
                };
                break;
            case "ol.layer.VectorTile":
                sourceTypeArray = new String[]{"ol.source.VectorTile"};
                break;
            default:
                sourceTypeArray = new String[]{};
                break;
        }

        return sourceTypeArray;
    }
}
