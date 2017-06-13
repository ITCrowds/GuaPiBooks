package com.itcrowds.guapibooks.controller.book;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Review;
import com.itcrowds.guapibooks.service.BookService;
import com.itcrowds.guapibooks.service.ReviewService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private NavigationBar navigationBar;

    @Resource
    private BookService bookService;

    @Resource
    private ReviewService reviewService;

    @RequestMapping("/info/{id}")
    public String readerSpacePage(Model model, @PathVariable("id") int id) {
        navigationBar.setNavigationBar(model);
        Book book = bookService.getBookById(id);
        List<Review> reviews = reviewService.getReviewByBookId(id);
        model.addAttribute("book",book);
        model.addAttribute("reviewList",reviews);
        return "books/bookinfo";
    }

    @RequestMapping("/gallery")
    public String  galleryPage(Model model){
        navigationBar.setNavigationBar(model);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("bookList",books);
        return "books/gallery";
    }
}

