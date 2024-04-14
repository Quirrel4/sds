package com.he.sds.vetical.entity;

import lombok.Data;

@Data
public class MineSection extends Section{

    public MineSection() {
    }

    public MineSection(String setctionId, String sectionName, String sectionSourceId, String description) {
        super(setctionId, sectionName, sectionSourceId, description);
    }
}
