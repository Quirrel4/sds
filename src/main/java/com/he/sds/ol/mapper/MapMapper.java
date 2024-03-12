package com.he.sds.ol.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Mapper
public interface MapMapper {
    public List<Map> findAllList();
    public List<Map> findMapsByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer findMapCount();
    public Integer insertMap(Map map);

    public Integer deleteMapsById(Set<String> mapIds);

    public Integer bindLayer(@Param("mapId")String mapId, @Param("layerIds")String[] layerIds);
}