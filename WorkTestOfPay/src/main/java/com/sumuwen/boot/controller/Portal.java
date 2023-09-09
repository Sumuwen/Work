package com.sumuwen.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Portal {
    @RequestMapping(value = {"/index",""})
    public String index(){
        return "site/index";
    }
}
