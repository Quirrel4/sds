package com.he.sds.ol.service.impl;

import com.he.sds.common.bean.BeanUtil;
import com.he.sds.common.exception.BusinessException;
import com.he.sds.ol.entity.Layer;
import com.he.sds.ol.entity.LayerSource;
import com.he.sds.ol.mapper.LayerMapper;
import com.he.sds.ol.mapper.SourceMapper;
import com.he.sds.ol.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LayerServiceImpl implements LayerService {
    @Autowired
    private LayerMapper layerMapper;

    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public List<LayerSource> findLayerList() {
        List<LayerSource> result = new ArrayList<>();
        LayerSource layerMap;
        String sourceId;
        List<Layer> layerList = layerMapper.findLayerList();
        for(int i = 0,len = layerList.size();i < len;i++){
            layerMap = new LayerSource();
            layerMap.setLayer(layerList.get(i));
            sourceId = layerList.get(i).getSource();
            if(sourceId != null && !"".equals(sourceId)){
                layerMap.setSource(sourceMapper.findSourceById(sourceId));
            }
            result.add(layerMap);
        }
        return result;
    }

    @Override
    public List<Layer> findSimpleLayerList() {
        return layerMapper.findLayerList();
    }

    @Override
    public List<java.util.Map<String,Object>> findLayersByPage(Integer pageSize, Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Layer> queryList = layerMapper.findLayersByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(layer -> {
            try {
                result.add(BeanUtil.Bean2Map(layer, Layer.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
    }

    @Override
    public Layer findeLayerById(String layerId) {
        return layerMapper.findeLayerById(layerId);
    }

    @Override
    public Layer findeLayerByName(String layerName) {
        return layerMapper.findeLayerByName(layerName);
    }

    @Override
    public List<LayerSource> findLayerByIds(String[] layerIds) {
        List<LayerSource> result = new ArrayList<>();
        if(layerIds != null){
            List<Layer> layerList = layerMapper.findLayerByIds(layerIds);
            Layer queryLayer;
            LayerSource layerSource;
            String sourceId;
            for(String layerId : layerIds){
                queryLayer = layerList
                        .stream()
                        .filter(layer -> layer.getLayerId().equals(layerId))
                        .findFirst()
                        .orElse(null);
                if(queryLayer != null){
                    layerSource = new LayerSource();
                    layerSource.setLayer(queryLayer);
                    sourceId = queryLayer.getSource();
                    layerSource.setSource(sourceMapper.findSourceById(sourceId));

                    result.add(layerSource);
                }
            }
        }

        return result;
    }

    @Override
    public Integer findLayerCount() {
        return layerMapper.findLayerCount();
    }

    @Override
    public Integer insertLayer(Layer layer) {
        layer.setLayerId(UUID.randomUUID().toString());
        return layerMapper.insertLayer(layer);
    }

    @Override
    public Integer bindSource(String layerId, String sourceId, Map<String, Object> options) {
        return layerMapper.bindSource(layerId,sourceId,options);
    }

    @Override
    public Integer deleteLayersById(Set<String> layerIds) {
        return layerMapper.deleteLayersById(layerIds);
    }
}
