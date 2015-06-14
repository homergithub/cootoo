package com.cootoo.metamanagement.domain;

public class Location {

    private String id;
    private String pId;
    private String name;
    private String treePath;
    private String unitType;
    private int restSize;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getpId() {
        return pId;
    }
    public void setpId(String pId) {
        this.pId = pId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTreePath() {
        return treePath;
    }
    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }
    public String getUnitType() {
        return unitType;
    }
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public int getRestSize() {
        return restSize;
    }

    public void setRestSize(int restSize) {
        this.restSize = restSize;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", pId=" + pId + ", name=" + name + "]";
    }


}
