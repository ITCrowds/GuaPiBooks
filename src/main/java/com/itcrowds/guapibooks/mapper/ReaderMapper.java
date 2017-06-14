package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Reader;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ReaderMapper {

    int getReaderCount();

    List<String> getAllReaderName();

    Reader getReaderByName(@Param("name") String name);

    Reader getReaderByEmail(@Param("email") String email);

    Reader getReaderById(@Param("id") int id);

    /**
     * 根据读者ID及阅读状态返回书籍ID列表
     *
     * @param id    读者ID
     * @param state 书籍阅读状态
     * @return 读者某阅读状态的书籍的ID列表
     */
    List<Integer> getBookIDListByReaderAndReadingState(@Param("id") int id, @Param("state") int state);

    List<Integer> getFollowingReaderIDList(@Param("id") int id);

    //下面三个函数用于修改读者对书的状态，有则更新，无则插入
    void insertBookReadingState(@Param("readerId") int readerId,
                                @Param("bookId") int bookId,
                                @Param("bookState") int bookState);

    void updateBookReadingState(@Param("readerId") int readerId,
                                @Param("bookId") int bookId,
                                @Param("bookState") int bookState);

    int getCountByReaderAndBook(@Param("readerId") int readerId,
                                @Param("bookId") int bookId);

    int getReaderCountByEmail(@Param("email") String email);

    void registerNewReader(@Param("name") String name, @Param("email") String email, @Param("password") String password);
}
