package com.dsr.mayi;

/**
 * 数据实体类，代表每一行数据
 */
public class DataInfo {
    /**
     * 第一列，id值
     */
    private String id;
    /**
     * 第二列，groupId(根据此列进行排序)
     */
    private String groupId;
    /**
     * 第三列，指标
     */
    private Float quota;

    public DataInfo(String id, String groupId, Float quota) {
        this.id = id;
        this.groupId = groupId;
        this.quota = quota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Float getQuota() {
        return quota;
    }

    public void setQuota(Float quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return  groupId +
                ", " + id +
                ", " + quota
                ;
    }
}
