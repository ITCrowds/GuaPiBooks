package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.mapper.BookMapper;
import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.mapper.ReviewMapper;
import com.itcrowds.guapibooks.service.ReaderService;
import com.itcrowds.guapibooks.util.Md5Util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public Reader getReaderById(int id) {
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
    public List<Reader> getFollowingReader(int readerId) {
        List<Reader> followingReaderList = new ArrayList<>();
        List<Integer> followingReaderIDList = readerMapper.getFollowingReaderIDList(readerId);
        for (int followingId : followingReaderIDList) {
            followingReaderList.add(readerMapper.getReaderById(followingId));
        }
        return followingReaderList;
    }

    @Override
    public boolean isLogin() {
        return !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    }

    @Override
    public Reader getLoginReader() {
        if (isLogin()) {
            return (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else {
            return null;
        }
    }

    @Override
    public void setBookReadingState(int readerId, int bookId, String bookReadingState) {
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

    @Override
    public boolean isReaderEmailExist(String readerEmail) {
        return 0 != readerMapper.getReaderCountByEmail(readerEmail);
    }

    @Override
    public void registerNewReader(String eamil, String password) {
        readerMapper.registerNewReader(eamil.split("@")[0], eamil, Md5Util.pwdDigest(password));
    }

}
