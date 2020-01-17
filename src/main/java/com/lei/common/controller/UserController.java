package com.lei.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lei.common.entity.User;
import com.lei.common.service.UserService;
import com.lei.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "interface")
public class UserController {
    @Autowired
    private UserService userService;

    // 查询用户
    @GetMapping("/user/all")
    @ResponseBody
    public ResponseEntity<Result> userList(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                           @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
                                           @RequestParam(value = "number", required = false) String number,
                                           @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "order", defaultValue = "+id") String order) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        // 使用分页PageHelper
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.getUserList(number, sex, order);
        PageInfo<User> pageInfo = new PageInfo(userList);
        // 全部用户条目
        int total = (int) pageInfo.getTotal();
        // 全部页数
        int totalPage = pageInfo.getPages();
        // 把结果数据放进封装类
        res.putData("total", total);
        res.putData("totalPage", totalPage);
        res.putData("users", pageInfo);
        // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
        return ResponseEntity.ok(res);
    }

    // 添加用户
    @PostMapping("/user/create")
    @ResponseBody
    public ResponseEntity<Result> createUser(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                             @RequestParam(value = "name") String name, @RequestParam(value = "phone") String phone,
                                             @RequestParam(value = "age") Integer age, @RequestParam(value = "sex") String sex,
                                             @RequestParam(value = "height") float height, @RequestParam(value = "weight") float weight) {
        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        String number = "NO_UMS-";
        int id = userService.getMaxId();
        if (id < 10) {
            number = number + "00000" + id;
        } else if (id < 100) {
            number = number + "0000" + id;
        } else {
            number = number + "000" + id;
        }
        boolean createResult = userService.createUser(number, name, age, sex, height, weight, phone);
        String result;
        if (createResult == true) {
            result = "success";
        } else {
            result = "fail";
        }
        res.putData("result", result);
        return ResponseEntity.ok(res);
    }

    // 删除用户
    @DeleteMapping("/user/remove")
    @ResponseBody
    public ResponseEntity<Result> removeUser(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                             @RequestParam(value = "id") Integer id) {
        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
        }
        boolean removeResult = userService.removeUser(id);
        String result;
        if (removeResult == true) {
            result = "success";
        } else {
            result = "fail";
        }
        res.putData("result", result);
        return ResponseEntity.ok(res);
    }

    // 编辑用户
    @PutMapping("/user/update")
    @ResponseBody
    public ResponseEntity<Result> updateUser(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad, @RequestParam(value = "name") String name,
                                             @RequestParam(value = "age") Integer age, @RequestParam(value = "sex") String sex,
                                             @RequestParam(value = "height") float height, @RequestParam(value = "weight") float weight,
                                             @RequestParam(value = "phone") String phone, @RequestParam(value = "id", required = true) Integer id) {
        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }
        boolean updateResult = userService.updateUser(id, name, age, sex, height, weight, phone);
        String result;
        if (updateResult == true) {
            result = "success";
        } else {
            result = "fail";
        }
        res.putData("result", result);
        return ResponseEntity.ok(res);
    }
}
