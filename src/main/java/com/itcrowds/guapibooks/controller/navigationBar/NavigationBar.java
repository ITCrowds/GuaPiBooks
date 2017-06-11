package com.itcrowds.guapibooks.controller.navigationBar;

import com.itcrowds.guapibooks.controller.HomeController;
import com.itcrowds.guapibooks.domain.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
// @Scope("prototype") //开启多例模式 默认单例
public class NavigationBar {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * 设置导航栏数据/状态 判断用户登录与否
     * @param model 调用者提供的model(controller中)
     */
    public void setNavigationBar(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
            model.addAttribute("isLogin", false);
            logger.info("NOT LOGIN");
        } else {
            Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("isLogin", true);
            model.addAttribute("readerName", reader.getName());
            logger.info("Reader is: " + reader.getName());
        }
    }
}
