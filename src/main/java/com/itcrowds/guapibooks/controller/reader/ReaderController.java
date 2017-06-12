package com.itcrowds.guapibooks.controller.reader;

import com.itcrowds.guapibooks.controller.navigationBar.NavigationBar;
import com.itcrowds.guapibooks.domain.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private NavigationBar navigationBar;

    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String readerSpacePage(Model model, HttpServletRequest request){
        Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("readerName", reader.getName());

        navigationBar.setNavigationBar(model);
        return "reader/readerSpace";
    }

    @RequestMapping("/testspace")
    public String testspace() {
        return "reader/userspace";
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
