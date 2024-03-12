package com.he.sds.ol.service;

import com.he.sds.ol.entity.Map;

import java.util.List;
import java.util.Set;

public interface MapService {
    public List<Map> findAllList();
    public List<java.util.Map<String,Object>> findMapsByPage(Integer pageSize,Integer currentPage);

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer findMapCount();
    public Integer insertMap(Map map);

    public Integer deleteMapsById(Set<String> mapIds);

    public Integer bindLayer(String mapId,String[] layerIds);
}
