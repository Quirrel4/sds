package com.he.sds.ol.entity;

import com.he.sds.common.bean.IntEnum;
import lombok.Data;

public enum StationStatus implements IntEnum<StationStatus> {
    ZC(0,0), CB(1,1), TC(2,-1), GZ(3,-2);

    private Integer index;
    private Integer statusCode;

    private StationStatus(Integer index,Integer statusCode){
        this.index = index;
        this.statusCode = statusCode;
    }

    @Override
    public Integer getIntValue() {
        return this.index;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


}
