package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface BookMapper {
    int getBookCount();

    List<String> getAllBookName();

    Book getBookByName(@Param("bookName") String bookName);

    Book getBookById(@Param("bookId") int bookId);

    List<Book> getAllBook();
}
