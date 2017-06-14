package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.domain.Tag;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {
    List<Tag> getTagById(@Param("tafId") int tagId);

    List<Tag> getTagListByreader(@Param("readerId") int readerId);
}
