package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;

import java.util.Collection;

public interface BookService {
    Book getBookById(int bookId);
}
