package com.taikang.demo.webcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eunice
 * @date 2018/9/18
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("toTestRedPoint")
    public String toTestRedPoint(){
        System.out.println(123);
        return "test";
    }
}
