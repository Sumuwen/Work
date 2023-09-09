package com.sumuwen.boot.controller;

import com.sumuwen.boot.pojo.Detail;
import com.sumuwen.boot.pojo.User;
import com.sumuwen.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*获取用户余额Balance*/
    @GetMapping("/user/{uid}")
    public String getBalance(@PathVariable("uid") Integer uid, Model model){
        Double balance = userService.getBalance(uid);
        return balance.toString();
    }

    /*用户消费*/
    @PutMapping("/user/consume/{uid}/{expenditure}")
    public String consume(@PathVariable("uid") Integer uid,
                          @PathVariable("expenditure") Double expenditure){
        Integer consumeResult = userService.consume(uid, expenditure);
        if(consumeResult > 0){
            return "消费成功！";
        }else {
            return "消费失败！";
        }
    }

    /*退款*/
    @PutMapping("/user/refund/{uid}/{expenditure}")
    public String refund(@PathVariable("uid") Integer uid,
                         @PathVariable("expenditure") Double expenditure){
        Integer refundResult = userService.refund(uid, expenditure);
        if(refundResult > 0){
            return "退款成功！";
        }else {
            return "退款失败！";
        }
    }
}
