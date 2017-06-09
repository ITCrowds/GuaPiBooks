package com.itcrowds.guapibooks.controller.reader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    /**
     * 读者书房
     */
    @RequestMapping("/readerspace")
    public String loginPage(){
        return "reader/readerSpace";
    }
}
