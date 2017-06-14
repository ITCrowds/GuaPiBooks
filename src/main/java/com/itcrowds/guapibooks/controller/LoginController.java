package com.itcrowds.guapibooks.controller;

import com.itcrowds.guapibooks.service.ReaderService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    private ReaderService readerService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "reader/login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "reader/register";
    }

    @RequestMapping(value = "/register/post", method = RequestMethod.POST)
    @ResponseBody
    public String registerNewReader(@RequestParam("email") String email,
                                    @RequestParam("password") String password) {
        if (readerService.isReaderEmailExist(email)) {
            return "exist";
        } else {
            readerService.registerNewReader(email, password);
            return "ok";
        }
    }
}
