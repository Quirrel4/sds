package com.he.sds.vetical.mapper;


import com.he.sds.vetical.entity.SectionSource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetionSourceMapper {

    public List<SectionSource> getSourceBySectionId(String sectionId);

    public boolean insertSectionSourceBySectionId(String sectionId,SectionSource ss);

    public boolean insertSectionSourceBySectionIdBatch(String sectionId,List<SectionSource> ssList);

    public boolean deleteSectionSourcesBySectionId(String sectionId);
}
