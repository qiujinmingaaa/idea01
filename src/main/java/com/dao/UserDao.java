package com.dao;

import com.domain.User;
import com.domain.User_simple;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User>  fundAll();
    void  addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    void updateUser01(Map map);
    User findUserById(int id);
    Map findMapById(int id);
    String findUsername(int id);
    int findCount();
    List<User> findUserByName(String name);
    List<User> findUserByName01(String name);
    List<User_simple> findUserByName02(String name);
}
