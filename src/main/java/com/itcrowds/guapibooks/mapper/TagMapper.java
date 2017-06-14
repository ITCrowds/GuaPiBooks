package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Tag;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    List<Tag> getTagById(@Param("tafId") int tagId);

    List<Tag> getTagListByreader(@Param("readerId") int readerId);
}
