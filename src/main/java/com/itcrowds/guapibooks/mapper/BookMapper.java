package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Book;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    int getBookCount();

    List<String> getAllBookName();

    Book getBookByName(@Param("bookName") String bookName);

    Book getBookById(@Param("bookId") int bookId);

    List<Book> getAllBook();
}
