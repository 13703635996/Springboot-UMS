package com.lei.common.service.serviceImpl;

import com.lei.common.entity.User;
import com.lei.common.mapper.UserMapper;
import com.lei.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(String number, String sex, String order) {
        String orderBy;
        if (order.equals("+id")) {
            orderBy = "asc";
        } else {
            orderBy = "desc";
        }
        return userMapper.getUserList(number, sex, orderBy);
    }

    @Override
    public boolean createUser(String number, String name, Integer age, String sex, float height, float weight, String phone) {
        return userMapper.createUser(number, name, age, sex, height, weight, phone);
    }

    @Override
    public boolean removeUser(Integer id) {
        return userMapper.removeUser(id);
    }

    @Override
    public boolean updateUser(Integer id, String name, Integer age, String sex, float height, float weight, String phone) {
        return userMapper.updateUser(id, name, age, sex, height, weight, phone);
    }

    @Override
    public int getMaxId() {
        return userMapper.getMaxId();
    }
}
