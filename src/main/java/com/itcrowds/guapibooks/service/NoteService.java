package com.itcrowds.guapibooks.service;


import com.itcrowds.guapibooks.domain.Note;

import java.util.List;

public interface NoteService {

    List<Note> getNoteListByReader(int readerId);
    void setReaderBookNote(int readerId, int bookId,String bookNote);
}
