package com.itcrowds.guapibooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /**
     * 跳转到登录页面
     */
    @RequestMapping("/login")
    public String loginPage(){
        return "reader/login";
    }
}
