package com.itcrowds.guapibooks.service;


import com.itcrowds.guapibooks.domain.Reader;

public interface ReaderService {

    /**
     * 检验用户密码是否正确
     * @param readerName 用户名
     * @param password 密码
     * @return 密码是否正确
     */
    boolean checkPassword(String readerName, String password);

    /**
     * 根据用户名获取用户
     * @param readerName 用户名
     * @return 用户
     */
    Reader getReaderByEmail(String readerName);

}
