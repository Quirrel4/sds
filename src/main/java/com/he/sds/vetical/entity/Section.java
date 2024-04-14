package com.he.sds.vetical.entity;

import lombok.Data;

@Data
public abstract class Section {
    String setctionId;
    String sectionName;
    String sectionSourceId;
    String description;

    public Section() {
    }

    public Section(String setctionId, String sectionName, String sectionSourceId, String description) {
        this.setctionId = setctionId;
        this.sectionName = sectionName;
        this.sectionSourceId = sectionSourceId;
        this.description = description;
    }
}
