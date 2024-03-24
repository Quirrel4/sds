package com.he.sds.ol.service.impl;

import com.he.sds.common.bean.BeanUtil;
import com.he.sds.common.exception.BusinessException;
import com.he.sds.ol.entity.Source;
import com.he.sds.ol.entity.TestStation;
import com.he.sds.ol.mapper.SourceMapper;
import com.he.sds.ol.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceMapper sourceDao;

    @Override
    public List<Source> findAllList() {
        return sourceDao.findAllList();
    }

    @Override
    public List<java.util.Map<String,Object>> findSourcesByPage(Integer pageSize, Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Source> queryList = sourceDao.findSourcesByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(source -> {
            try {
                result.add(BeanUtil.Bean2Map(source, Source.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
    }

    @Override
    public Source findSourceById(String sourceId) {
        return sourceDao.findSourceById(sourceId);
    }

    @Override
    public Source findSourceByName(String sourceName) {
        return sourceDao.findSourceByName(sourceName);
    }

    @Override
    public List<Source> findSourceByType(String[] sourceTypes,String projection) {
        return sourceDao.findSourceByType(sourceTypes,projection);
    }

    @Override
    public Integer findSourceCount() {
        return sourceDao.findSourceCount();
    }

    @Override
    public Integer insertSource(Source source) {
        source.setSourceId(UUID.randomUUID().toString());
        return sourceDao.insertSource(source);
    }

    @Override
    public Integer updateSource(Source source) {
        return sourceDao.updateSource(source);
    }

    @Override
    public Integer deleteSourcesById(Set<String> sourceIds) {
        return sourceDao.deleteSourcesById(sourceIds);
    }

    @Override
    public Integer insertTestStation(TestStation testStation) {
        return sourceDao.insertTestStation(testStation);
    }

    @Override
    public List<TestStation> findTestStationList() {
        return sourceDao.findTestStationList();
    }
}