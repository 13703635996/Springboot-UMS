package com.lei.common.service.serviceImpl;

import com.lei.common.entity.Manager;
import com.lei.common.mapper.ManagerMapper;
import com.lei.common.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public int getManager(String name, String password) {
        return managerMapper.getManager(name, password);
    }

    @Override
    public List<Manager> getManagerInfo(String username) {
        return managerMapper.getManagerInfo(username);
    }

    @Override
    public String getManagerRoles(String token) {
        return managerMapper.getManagerRoles(token);
    }
}
