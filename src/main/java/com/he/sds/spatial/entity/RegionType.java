package com.he.sds.spatial.entity;


public enum RegionType {
    PROVINCE("geoprovince"), CITY("geocity"), COUNTRY("geocountry"), TOWN("geotown");

    private String name;

    private RegionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionType ChildType() {
        RegionType childType = null;
        switch (this) {
            case PROVINCE:
                childType = RegionType.CITY;
                break;
            case CITY:
                childType = RegionType.COUNTRY;
                break;
            case COUNTRY:
                childType = RegionType.TOWN;
                break;
        }
        return childType;
    }
}
