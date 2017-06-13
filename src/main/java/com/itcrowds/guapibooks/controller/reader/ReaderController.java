package com.itcrowds.guapibooks.controller.reader;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.service.ReaderService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Resource
    private NavigationBar navigationBar;

    @Resource
    private ReaderService readerService;

    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String readerSpacePage(Model model, HttpServletRequest request){
        Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("reader", reader);

        navigationBar.setNavigationBar(model);
        return "reader/readerSpace";
    }

    @RequestMapping("readState")
    public String bookState(Model model) {
        Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("readingBooks", readerService.getBookListByReaderAndReadingState(reader.getId(), Reader.READING));
        model.addAttribute("toReadBooks", readerService.getBookListByReaderAndReadingState(reader.getId(), Reader.TOREAD));
        model.addAttribute("readedBooks", readerService.getBookListByReaderAndReadingState(reader.getId(), Reader.READED));
        return "reader/readState";
    }

    @RequestMapping("bookList")
    public String bookList(Model model) {
        return "reader/bookList";
    }

    @RequestMapping("/bookNote")
    public String bookNote(Model model) {
        return "reader/bookNote";
    }

    @RequestMapping("bookReview")
    public String bookReview(Model model) {
        return "reader/bookReview";
    }

    @RequestMapping("bookTag")
    public String bookTag(Model model) {
        return "reader/bookTag";
    }

    @RequestMapping("friend")
    public String friend(Model model) {
        return "reader/friend";
    }
}
