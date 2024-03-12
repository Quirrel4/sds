package com.he.sds.ol.service;


import com.he.sds.ol.entity.Layer;
import com.he.sds.ol.entity.LayerSource;

import java.util.List;
import java.util.Set;

public interface LayerService {
    public List<LayerSource> findLayerList();

    /**
     * 获取地图中需要设置的图层列表
     * @return
     */
    public List<Layer> findSimpleLayerList();
    public List<java.util.Map<String,Object>> findLayersByPage(Integer pageSize,Integer currentPage);

    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);
    public List<LayerSource> findLayerByIds(String[] layerIds);
    public Integer findLayerCount();
    public Integer insertLayer(Layer layer);
    public Integer bindSource(String layerId,String sourceId,java.util.Map<String,Object> options);
    public Integer deleteLayersById(Set<String> layerIds);
}
