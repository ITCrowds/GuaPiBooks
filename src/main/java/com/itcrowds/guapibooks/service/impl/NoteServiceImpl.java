package com.itcrowds.guapibooks.service.impl;


import com.itcrowds.guapibooks.domain.Note;
import com.itcrowds.guapibooks.mapper.NoteMapper;
import com.itcrowds.guapibooks.service.NoteService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteMapper noteMapper;

    @Override
    public List<Note> getNoteListByReader(int readerId) {
        return noteMapper.getNoteListByreader(readerId);
    }
}
