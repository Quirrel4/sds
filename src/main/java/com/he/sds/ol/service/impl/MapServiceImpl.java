package com.he.sds.ol.service.impl;

import com.he.sds.common.bean.BeanUtil;
import com.he.sds.common.exception.BusinessException;
import com.he.sds.ol.entity.Map;
import com.he.sds.ol.mapper.MapMapper;
import com.he.sds.ol.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapMapper mapMapper;

    @Override
    public List<Map> findAllList() {
        return mapMapper.findAllList();
    }

    @Override
    public List<java.util.Map<String,Object>> findMapsByPage(Integer pageSize,Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Map> queryList = mapMapper.findMapsByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(map -> {
            try {
                result.add(BeanUtil.Bean2Map(map, Map.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
    }

    @Override
    public Map findMapById(String mapId) {
        return mapMapper.findMapById(mapId);
    }

    @Override
    public Map findMapByName(String mapName) {
        return mapMapper.findMapByName(mapName);
    }

    @Override
    public Integer findMapCount() {
        return mapMapper.findMapCount();
    }

    @Override
    public Integer insertMap(Map map) {
        map.setMapId(UUID.randomUUID().toString());
        return mapMapper.insertMap(map);
    }

    @Override
    public Integer deleteMapsById(Set<String> mapIds) {
        return mapMapper.deleteMapsById(mapIds);
    }

    @Override
    public Integer bindLayer(String mapId, String[] layerIds) {
        return mapMapper.bindLayer(mapId,layerIds);
    }
}
