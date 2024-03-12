package com.he.sds.spatial.dao;


import com.he.sds.spatial.entity.Region;
import com.he.sds.spatial.entity.RegionCenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface RegionDao {
    public Region findRegionByCode(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public String findRgionCenterByCode(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public List<Region> findAroundRegions(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public List<Region> findRegionsByParentCode(
            @Param("reginTable") String reginTable,
            @Param("parentCode") String parentCode
    );

    public List<RegionCenter> findRegionCentersByParentCode(
            @Param("reginTable") String reginTable,
            @Param("parentCode") String parentCode
    );
}
