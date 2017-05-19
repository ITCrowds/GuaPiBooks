package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Reader;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 使用注解构建SQL
@Mapper
public interface ReaderMapperAlt {

    @ResultType(int.class)
    @Select("SELECT count(READER_ID) FROM READER")
    int getReaderCount();

    @ResultType(String.class)
    @Select("SELECT READER_NAME FROM READER")
    List<String> getAllReaderName();

    @Results({
            @Result(column="READER_ID", property="id", javaType = Integer.class),
            @Result(column="READER_NAME", property="name", javaType = String.class),
            @Result(column="READER_EMAIL", property="emailAddress"),
            @Result(column="READER_PASSWORD", property="password")
    })
    @ResultType(Reader.class)
    @Select("SELECT * FROM READER WHERE READER_NAME = #{name}")
    Reader getReaderByName(@Param("name") String name);

    @ResultType(String.class)
    @Select("SELETE PASSWORD FROM READER WHERE READER_NAME = #{name}")
    String getPasswordByName(@Param("name") String name);

}
