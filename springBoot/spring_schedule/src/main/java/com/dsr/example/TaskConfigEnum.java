package com.dsr.example;

public enum TaskConfigEnum {
    TASK1("任务1","com.dsr.task1","group1",1),
    TASK2("任务1","com.dsr.task1","group1",1),
    TASK3("任务1","com.dsr.task1","group1",1);

    private String desc;
    private String classPath;
    private String group;
    private Integer poolSize;

    TaskConfigEnum(String desc, String classPath, String group, int poolSize) {
        this.desc = desc;
        this.classPath = classPath;
        this.group = group;
        this.poolSize = poolSize;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }
}
