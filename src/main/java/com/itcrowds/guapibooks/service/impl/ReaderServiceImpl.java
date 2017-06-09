package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Reader;
import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.service.ReaderService;
import com.itcrowds.guapibooks.util.Md5Util;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderMapper readerMapper;

    @Override
    public boolean checkPassword(String readerName, String password) {
        return Md5Util.pwdDigest(password).equals(readerMapper.getReaderByName(readerName).getPassword());
    }

    @Override
    public Reader getReaderByEamil(String email) {
        return readerMapper.getReaderByEmail(email);
    }
}
