package com.itcrowds.guapibooks.controller;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
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
