package com.dsr.testspring.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {
    public void insert(String sqlId, Map<String,Object> para);
    public void delete(String sqlId, Map<String,Object> para);
    public void update(String sqlId, Map<String,Object> para);
    public List query(String sqlId, Map<String,Object> para);
}
