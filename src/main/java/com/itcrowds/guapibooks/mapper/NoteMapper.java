package com.itcrowds.guapibooks.mapper;


import com.itcrowds.guapibooks.domain.Note;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {
    List<Note> getNoteListByreader(@Param("readerId") int readerId);

}
