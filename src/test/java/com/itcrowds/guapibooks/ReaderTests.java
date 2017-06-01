package com.itcrowds.guapibooks;

import com.itcrowds.guapibooks.mapper.ReaderMapper;
import com.itcrowds.guapibooks.service.ReaderService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReaderTests {
    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private ReaderService readerService;

    @Test
    public void test() throws Exception {
        Assert.assertEquals(4, readerMapper.getReaderCount());
        Assert.assertEquals("user1@163.com", readerMapper.getReaderByName("user1").getEmailAddress());
        Assert.assertEquals(4, readerMapper.getAllReaderName().size());

        Assert.assertEquals(4, readerMapper.getReaderCount());
        Assert.assertEquals("user1@163.com", readerMapper.getReaderByName("user1").getEmailAddress());
        Assert.assertEquals(4, readerMapper.getAllReaderName().size());

        Assert.assertTrue(readerService.checkPassword("user3", "user3password"));
    }
}
