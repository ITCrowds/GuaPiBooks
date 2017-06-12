package com.itcrowds.guapibooks.domain;

import org.apache.ibatis.type.Alias;

@Alias("booklist")
public class BookList {
    private int boolListId;
    private int readerId;
    private String bookListName;

    public int getBoolListId() {
        return boolListId;
    }

    public void setBoolListId(int boolListId) {
        this.boolListId = boolListId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getBookListName() {
        return bookListName;
    }

    public void setBookListName(String bookListName) {
        this.bookListName = bookListName;
    }
}
