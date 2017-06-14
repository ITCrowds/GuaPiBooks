package com.itcrowds.guapibooks.controller.reader;

import com.itcrowds.guapibooks.controller.HomeController;
import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.service.ReaderService;
import com.itcrowds.guapibooks.util.ReaderLoggingStatusHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private ReaderLoggingStatusHelper readerLoggingStatusHelper;

    @Resource
    private NavigationBar navigationBar;

    @Resource
    private ReaderService readerService;

    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String readerSpacePage(Model model, HttpServletRequest request) {
        Reader reader = readerLoggingStatusHelper.getLoginReader();
        model.addAttribute("reader", reader);

        navigationBar.setNavigationBar(model);
        return "reader/readerSpace";
    }

    @RequestMapping("readState")
    public String bookState(Model model) {
        Reader reader = readerLoggingStatusHelper.getLoginReader();
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

    @RequestMapping(value = "bookState", method = RequestMethod.POST)
    @ResponseBody
//    public Reader postBookState(@RequestBody Reader reader, Model model,
    public String postBookState(Model model,
                                @RequestParam("bookId") String bookId,
                                @RequestParam("bookState") String bookState) {
        logger.info(bookId);
        Reader reader = readerLoggingStatusHelper.getLoginReader();
        readerService.setBookReadingState(reader.getId(), Integer.valueOf(bookId), bookState);
        return "ok";
    }
}
