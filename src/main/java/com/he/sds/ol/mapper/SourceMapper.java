package com.he.sds.ol.mapper;

import com.he.sds.ol.entity.Source;
import com.he.sds.ol.entity.TestStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface SourceMapper {
    public List<Source> findAllList();
    public List<Source> findSourcesByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);
    public Source findSourceById(String sourceId);
    public Source findSourceByName(String sourceName);
    public List<Source> findSourceByType(
            @Param("sourceTypes") String[] sourceTypes,
            @Param("projection") String projection);
    public Integer findSourceCount();
    public Integer insertSource(Source source);
    public Integer updateSource(Source source);
    public Integer deleteSourcesById(Set<String> sourceIds);

    public Integer insertTestStation(TestStation testStation);
    public List<TestStation> findTestStationList();
}
