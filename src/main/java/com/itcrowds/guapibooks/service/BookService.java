package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;

import java.util.Collection;
import java.util.List;

public interface BookService {
    Book getBookById(int bookId);
    List<Book> getAllBooks();
}
