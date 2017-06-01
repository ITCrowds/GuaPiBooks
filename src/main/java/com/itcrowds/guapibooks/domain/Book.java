package com.itcrowds.guapibooks.domain;

/**
 * Created by user on 2017/5/25.
 */
public class Book {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private String book_isbn;
    private Integer book_views;
    private Integer book_marks;
    private String book_introduction;
    private String book_pic;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public Integer getBook_views() {
        return book_views;
    }

    public void setBook_views(Integer book_views) {
        this.book_views = book_views;
    }

    public Integer getBook_marks() {
        return book_marks;
    }

    public void setBook_marks(Integer book_marks) {
        this.book_marks = book_marks;
    }

    public String getBook_introduction() {
        return book_introduction;
    }

    public void setBook_introduction(String book_introduction) {
        this.book_introduction = book_introduction;
    }

    public String getBook_pic() {
        return book_pic;
    }

    public void setBook_pic(String book_pic) {
        this.book_pic = book_pic;
    }
}
