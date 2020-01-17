package com.lei.common.service;

import com.lei.common.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(String number, String sex, String order);

    boolean createUser(String number, String name, Integer age, String sex, float height, float weight, String phone);

    boolean removeUser(Integer id);

    boolean updateUser(Integer id, String name, Integer age, String sex, float height, float weight, String phone);

    int getMaxId();
}
