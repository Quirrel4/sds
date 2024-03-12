package com.he.sds.ol.mapper;

import com.he.sds.ol.entity.Layer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface LayerMapper {
    public List<Layer> findLayerList();
    public List<Layer> findLayersByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);

    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);
    public List<Layer> findLayerByIds(String[] layerIds);
    public Integer findLayerCount();
    public Integer insertLayer(Layer layer);

    public Integer bindSource(
            @Param("layerId") String layerId,
            @Param("sourceId") String sourceId,
            @Param("options") java.util.Map<String,Object> options
    );
    public Integer deleteLayersById(Set<String> layerIds);
}

