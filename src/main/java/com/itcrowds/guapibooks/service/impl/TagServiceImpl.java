package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Tag;
import com.itcrowds.guapibooks.mapper.TagMapper;
import com.itcrowds.guapibooks.service.TagService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class TagServiceImpl implements TagService{
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> getTagById(@Param("tafId") int tagId) {
        return tagMapper.getTagById(tagId);
    }

    @Override
    public List<Tag> getTagListByreader(@Param("readerId") int readerId) {
        return tagMapper.getTagListByreader(readerId);
    }
}