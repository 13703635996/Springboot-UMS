package com.lei.common.mapper;

import com.lei.common.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "ManagerMapper")
public interface ManagerMapper {
    int getManager(String name, String password);

    List<Manager> getManagerInfo(String username);

    String getManagerRoles(String token);
}
