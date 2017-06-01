package com.itcrowds.guapibooks;

import com.itcrowds.guapibooks.mapper.BookMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 2017/5/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test() throws Exception {
        Assert.assertEquals(2, bookMapper.getBookCount());
        Assert.assertEquals("机器学习", bookMapper.getBookByName("机器学习").getBook_name());
        Assert.assertEquals(2, bookMapper.getAllBookName().size());
    }
}
