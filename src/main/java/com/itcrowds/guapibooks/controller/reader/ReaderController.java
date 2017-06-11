package com.itcrowds.guapibooks.controller.reader;

import com.itcrowds.guapibooks.domain.Reader;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String readerSpacePage(Model model, HttpServletRequest request){
        Reader reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("reader", reader.getName());
        return "reader/readerSpace";
    }
}
