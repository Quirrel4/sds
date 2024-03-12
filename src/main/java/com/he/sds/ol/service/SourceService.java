package com.he.sds.ol.service;

import com.he.sds.ol.entity.Source;
import com.he.sds.ol.entity.TestStation;

import java.util.List;
import java.util.Set;

public interface SourceService {
    public List<Source> findAllList();
    public List<java.util.Map<String,Object>> findSourcesByPage(Integer pageSize,Integer currentPage);
    public Source findSourceById(String sourceId);
    public Source findSourceByName(String sourceName);
    public List<Source> findSourceByType(String[] sourceTypes,String projection);
    public Integer findSourceCount();

    public Integer insertSource(Source source);
    public Integer updateSource(Source source);
    public Integer deleteSourcesById(Set<String> sourceIds);

    public Integer insertTestStation(TestStation testStation);
    public List<TestStation> findTestStationList();
}
