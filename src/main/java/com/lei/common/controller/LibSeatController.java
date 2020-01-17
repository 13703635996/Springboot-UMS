package com.lei.common.controller;

import com.lei.common.entity.LibSeat;
import com.lei.common.service.LibSeatService;
import com.lei.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "interface")
public class LibSeatController {
    @Autowired
    private LibSeatService libSeatService;

    // 查询座位
    @GetMapping("/lib/seat")
    @ResponseBody
    public ResponseEntity<Result> allSeat(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                          @RequestParam(value = "floor",defaultValue = "1") Integer floor,@RequestParam(value = "number",defaultValue = "1") Integer number) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }

        List<LibSeat> libSeats = libSeatService.getAllSeat(floor,number);

        // 把结果数据放进封装类

        res.putData("seats", libSeats);
        // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
        return ResponseEntity.ok(res);
    }

    // 按条件查询座位
    @GetMapping("/lib/searchSeat")
    @ResponseBody
    public ResponseEntity<Result> searchSeat(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                             @RequestParam(value = "floor",defaultValue = "1") Integer floor,@RequestParam(value = "parity") Integer parity,
                                             @RequestParam(value = "number") Integer number) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }

        List<LibSeat> libSeats = libSeatService.searchSeat(floor,parity,number);

        // 把结果数据放进封装类

        res.putData("seats", libSeats);
        // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
        return ResponseEntity.ok(res);
    }

    // 占座
    @PutMapping("/lib/selectSeat")
    @ResponseBody
    public ResponseEntity<Result> selectSeat(@RequestParam(value = "bad", required = false, defaultValue = "false") boolean bad,
                                             @RequestParam(value = "id") Integer id,@RequestParam(value = "user") String user,
                                             @RequestParam(value = "begin") String begin,@RequestParam(value = "end") String end) {

        Result res = new Result(200, "ok");

        if (bad) {
            res.setStatus(400);
            res.setMessage("Bad request");

            // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回400
            return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);

        }

        boolean result = libSeatService.selectSeat(id,user,begin,end);

        // 把结果数据放进封装类

        res.putData("result", result);
        // ResponseEntity是响应实体泛型，通过它可以设置http响应的状态值，此处返回200
        return ResponseEntity.ok(res);
    }

    // 释放座位
}
