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
}
