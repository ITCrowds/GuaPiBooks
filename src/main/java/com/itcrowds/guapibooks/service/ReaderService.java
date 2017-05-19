package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.mapper.ReaderMapperAlt;
import com.itcrowds.guapibooks.util.Md5Util;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReaderService {
    @Resource
    private ReaderMapperAlt readerMapperAlt;

    public boolean checkPassword(String username, String password) {
        return Md5Util.pwdDigest(password).equals(readerMapperAlt.getReaderByName(username).getPassword());
    }
}
