package com.lei.common.mapper;

import com.lei.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "UserMapper")
public interface UserMapper {

    List<User> getUserList(String number, String sex,String orderBy);

    boolean createUser(String number, String name, Integer age, String sex, float height, float weight, String phone);

    boolean removeUser(Integer id);

    boolean updateUser(Integer id, String name, Integer age, String sex, float height, float weight, String phone);

    int getMaxId();
}
