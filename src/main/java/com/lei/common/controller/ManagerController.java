package com.lei.common.controller;

import com.lei.common.entity.Manager;
import com.lei.common.service.ManagerService;
import com.lei.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "interface")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    // 查询全部用户
    @GetMapping("user/login")
    @ResponseBody
    public ResponseEntity<Result> userList(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                           @RequestParam(value = "username") String username,
                                           @RequestParam(value = "password") String password) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        int count = managerService.getManager(username, password);
        if (count < 1) {
            res.putData("result", "none");
        } else {
            List<Manager> managerList = managerService.getManagerInfo(username);

            res.putData("managerInfo", managerList);
            res.putData("result", "existence");
        }
        return ResponseEntity.ok(res);
    }

    // 获取roles
    @GetMapping("user/info")
    @ResponseBody
    public ResponseEntity<Result> userInfo(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                           @RequestParam(value = "token") String token) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        String roles = managerService.getManagerRoles(token);
        res.putData("roles", roles);
        return ResponseEntity.ok(res);
    }

    // 退出
    @PostMapping("user/logout")
    @ResponseBody
    public ResponseEntity<Result> userLogout(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        res.putData("result", "success");
        return ResponseEntity.ok(res);
    }
}
