package com.lei.common.service;

import com.lei.common.entity.Manager;

import java.util.List;

public interface ManagerService {
    int getManager(String name, String password);

    List<Manager> getManagerInfo(String username);

    String getManagerRoles(String token);
}
