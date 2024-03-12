package com.he.sds.vetical.mapper;

import com.he.sds.vetical.entity.MineSection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MineSectionMapper {

    public MineSection getMineSectionBySampleTrace(String SampleTraceId);

    public boolean insertMineSection(MineSection ms,String sampleLineId);

    public boolean deleteMineSectionById(String id);
}
