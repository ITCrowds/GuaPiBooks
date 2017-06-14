package com.itcrowds.guapibooks.service;


import com.itcrowds.guapibooks.domain.Book;
import com.itcrowds.guapibooks.domain.Reader;

import java.util.List;

public interface ReaderService {

    /**
     * 检验用户密码是否正确
     *
     * @param readerName 用户名
     * @param password   密码
     * @return 密码是否正确
     */
    boolean checkPassword(String readerName, String password);

    /**
     * 根据用户名获取用户
     *
     * @param readerName 用户名
     * @return 用户
     */
    Reader getReaderByEmail(String readerName);

    Reader getReaderById(int readerId);

    /**
     * 根据读者的ID获取读者正在阅读的书籍列表
     *
     * @param readerId     读者ID
     * @param readingState 书籍阅读状态
     * @return 正在阅读的书籍列表
     */
    List<Book> getBookListByReaderAndReadingState(int readerId, int readingState);

    /**
     * 获取读者关注的用户
     *
     * @param readerId 读者ID
     * @return 关注的用户列表
     */
    List<Reader> getFollowingReader(int readerId);

    /**
     * 获取用户是否已经登录
     *
     * @return 用户是否已经登录
     */
    boolean isLogin();

    /**
     * 获取当前用户
     *
     * @return 返回当前reader, 没有登录返回NULL
     */
    Reader getLoginReader();

    void setBookReadingState(int readerId, int bookId, String readingState);

}
