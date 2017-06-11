package com.itcrowds.guapibooks.controller.book;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @RequestMapping("/info/{id}")
    public String readerSpacePage(Model model, @PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book_name",book.getBook_name());
        model.addAttribute("book_author",book.getBook_author());
        model.addAttribute("book_isbn",book.getBook_isbn());
        return "books/bookinfo";
    }
}

