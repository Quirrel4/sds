package com.he.sds.spatial.dao;


import com.he.sds.spatial.entity.ModelRiver;
import com.he.sds.spatial.entity.SeparatedRiver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


@Mapper
public interface RiverDao {
    public List<SeparatedRiver> findRiversByStationCodes(@Param("stationCodes") Set<String> stationCodes);
    public List<SeparatedRiver> findRiversByRiverCodes(@Param("riverCodes") Set<String> riverCodes);

    public List<ModelRiver> findModelRiverInfo();
    public List<ModelRiver> findModelRiverByName(@Param("riverName") String riverName);
}
