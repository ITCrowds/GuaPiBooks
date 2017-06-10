package com.itcrowds.guapibooks.controller;

import com.itcrowds.guapibooks.domain.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * 主页面
     */
    @RequestMapping("/")
    public String homePage(Model model){

        if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
            model.addAttribute("isLogin", false);
            logger.info("NOT LOGIN");
        } else {
            Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("isLogin", true);
            model.addAttribute("readerName", reader.getName());
            logger.info("Reader is: " + reader.getName());
        }
        return "books/index";
    }
}
