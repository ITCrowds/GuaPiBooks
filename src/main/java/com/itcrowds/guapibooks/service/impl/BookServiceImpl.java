package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.mapper.BookMapper;
import com.itcrowds.guapibooks.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class BookServiceImpl implements BookService{
    @Resource
    private BookMapper bookMapper;

    @Override
    public Book getBookById(int bookId){
        return bookMapper.getBookById(bookId);
    }

}
