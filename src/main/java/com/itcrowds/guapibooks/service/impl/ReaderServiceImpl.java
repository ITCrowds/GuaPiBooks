package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.mapper.BookMapper;
import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.service.ReaderService;
import com.itcrowds.guapibooks.util.Md5Util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderMapper readerMapper;
    @Resource
    private BookMapper bookMapper;

    @Override
    public boolean checkPassword(String readerName, String password) {
        return Md5Util.pwdDigest(password).equals(readerMapper.getReaderByName(readerName).getPassword());
    }

    @Override
    public Reader getReaderByEmail(String email) {
        return readerMapper.getReaderByEmail(email);
    }

     @Override
    public Reader getReaderById(int id){
        return readerMapper.getReaderById(id);
     }

    @Override
    public List<Book> getBookListByReaderAndReadingState(int readerId, int readingState) {
        List<Book> readingBookList = new ArrayList<>();
        List<Integer> readingBookIDList = readerMapper.getBookIDListByReaderAndReadingState(readerId, readingState);
        for (int bookId : readingBookIDList) {
            readingBookList.add(bookMapper.getBookById(bookId));
        }
        return readingBookList;
    }

    @Override
    public void setBookReadingState(int readerId,int bookId,String bookReadingState) {
        Reader reader = readerMapper.getReaderById(readerId);
        int readingState;
        if (bookReadingState.equals("toread")) {
            readingState = Reader.TOREAD;
        } else if (bookReadingState.equals("reading")) {
            readingState = Reader.READING;
        } else {
            readingState = Reader.READED;
        }

        if (readerMapper.getCountByReaderAndBook(readerId, bookId) == 0) {
            readerMapper.insertBookReadingState(readerId, bookId, readingState);
        } else {
            readerMapper.updateBookReadingState(readerId, bookId, readingState);
        }
    }
}
