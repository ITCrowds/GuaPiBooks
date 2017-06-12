package com.itcrowds.guapibooks.domain;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("book")
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookIsbn;
    private Integer bookViews;
    private Integer bookMarks;
    private String bookIntroduction;
    private String bookPic;

    private List<Reader> readers;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Integer getBookViews() {
        return bookViews;
    }

    public void setBookViews(Integer bookViews) {
        this.bookViews = bookViews;
    }

    public Integer getBookMarks() {
        return bookMarks;
    }

    public void setBookMarks(Integer bookMarks) {
        this.bookMarks = bookMarks;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic;
    }
}
