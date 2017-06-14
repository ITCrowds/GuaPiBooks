package com.itcrowds.guapibooks.controller;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.Resource;

@Controller
public class HomeController
{
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private NavigationBar navigationBar;

    @Resource
    private BookService bookService;

    /**
     * 主页面
     */
    @RequestMapping("/")
    // public String homePage(Model model){
    //     navigationBar.setNavigationBar(model);
    //     return "books/index";
    // }
    public String  galleryPage(Model model){
        navigationBar.setNavigationBar(model);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("bookList",books);
        return "books/gallery";
    }
}
