package com.dsr.dao;

import com.dsr.bean.User;

public interface UserDao {
    public User getUserById(Integer id);
    public int updateUser(User user);
    public int deleteUser(User user);
    public int saveUser(User user);
}
