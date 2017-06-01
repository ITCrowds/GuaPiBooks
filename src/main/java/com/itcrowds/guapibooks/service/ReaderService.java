package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.util.Md5Util;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReaderService {
    @Resource
    private ReaderMapper readerMapper;

    public boolean checkPassword(String username, String password) {
        return Md5Util.pwdDigest(password).equals(readerMapper.getReaderByName(username).getPassword());
    }
}
