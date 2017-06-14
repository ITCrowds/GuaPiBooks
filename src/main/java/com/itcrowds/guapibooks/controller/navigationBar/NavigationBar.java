package com.itcrowds.guapibooks.controller.navigationBar;

import com.itcrowds.guapibooks.controller.HomeController;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.util.ReaderLoggingStatusHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 * 状态栏数据
 */
@Component
// @Scope("prototype") //开启多例模式 默认单例
public class NavigationBar {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private ReaderLoggingStatusHelper readerLoggingStatusHelper;

    /**
     * 设置导航栏数据/状态 判断用户登录与否
     * @param model 调用者提供的model(controller中)
     */
    public void setNavigationBar(Model model) {
        if (readerLoggingStatusHelper.isLogin()) {
            Reader reader = readerLoggingStatusHelper.getLoginReader();
            model.addAttribute("isLogin", true);
            model.addAttribute("readerName", reader.getName());
            logger.info("Reader is: " + reader.getName());
        } else {
            model.addAttribute("isLogin", false);
            logger.info("NOT LOGIN");
        }
    }
}
