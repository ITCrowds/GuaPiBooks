package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by user on 2017/5/25.
 */
public interface BookMapper {
    int getBookCount();

    List<String> getAllBookName();

    Book getBookByName(@Param("book_name") String book_name);

    Book getBookById(@Param("book_id") int book_id);
}
