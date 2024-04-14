package com.he.sds.vetical.entity;

import lombok.Data;

@Data
public abstract class MaterialByte {
    String materialId;
    String materialName;
    String legend;      //图例
    String description;
}
