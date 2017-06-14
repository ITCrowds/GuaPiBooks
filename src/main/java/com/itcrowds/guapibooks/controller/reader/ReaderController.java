package com.itcrowds.guapibooks.controller.reader;

import com.itcrowds.guapibooks.controller.HomeController;
import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.domain.Review;
import com.itcrowds.guapibooks.service.BookService;
import com.itcrowds.guapibooks.service.NoteService;
import com.itcrowds.guapibooks.service.ReaderService;
import com.itcrowds.guapibooks.service.ReviewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource
    private NavigationBar navigationBar;

    @Resource
    private ReaderService readerService;

    @Resource
    private ReviewService reviewService;

    @Resource
    private BookService bookService;

    @Resource
    private NoteService noteService;

    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String readerSpacePage(Model model, HttpServletRequest request){
        Reader reader = readerService.getLoginReader();
        model.addAttribute("reader", reader);

        navigationBar.setNavigationBar(model);
        return "reader/readerSpace";
    }

    @RequestMapping("readState")
    public String bookState(Model model) {
        Reader reader = readerService.getLoginReader();
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
        Reader reader = readerService.getLoginReader();
        model.addAttribute("readerName", reader.getName());
            model.addAttribute("notes", noteService.getNoteListByReader(reader.getId()));
        return "reader/bookNote";
    }

    @RequestMapping("bookReview")
    public String bookReview(Model model) {
        Reader reader = readerService.getLoginReader();
        List<Book> books = new ArrayList<>();
        List<Review> reviews = reviewService.getReviewByReaderId(reader.getId());
        for (Review re : reviews) {
            books.add(bookService.getBookById(re.getBookId()));
        }
        model.addAttribute("reviews", reviews);
        model.addAttribute("books", books);
        return "reader/bookReview";
    }

    @RequestMapping("bookTag")
    public String bookTag(Model model) {
        Reader reader = readerService.getLoginReader();

        return "reader/bookTag";
    }

    @RequestMapping("friend")
    public String friend(Model model) {
        Reader reader = readerService.getLoginReader();
        List<Reader> rea = readerService.getFollowingReader(reader.getId());
        model.addAttribute("followingReaders", rea);
        return "reader/friend";
    }

    @RequestMapping(value = "bookState", method = RequestMethod.POST)
    @ResponseBody
//    public Reader postBookState(@RequestBody Reader reader, Model model,
    public String postBookState(Model model,
                                @RequestParam("bookId") String bookId,
                                @RequestParam("bookState") String bookState) {
        logger.info(bookId);
        Reader reader = readerService.getLoginReader();
        readerService.setBookReadingState(reader.getId(), Integer.valueOf(bookId), bookState);
        return "ok";
    }
}
