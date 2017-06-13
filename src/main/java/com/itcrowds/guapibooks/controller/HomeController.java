package com.itcrowds.guapibooks.controller;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController
{
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private NavigationBar navigationBar;

    /**
     * 主页面
     */
    @RequestMapping("/")
    public String homePage(Model model){
        navigationBar.setNavigationBar(model);

        return "books/index";
    }
}
