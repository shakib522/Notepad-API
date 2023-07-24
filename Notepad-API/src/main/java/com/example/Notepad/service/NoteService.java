package com.example.Notepad.service;

import com.example.Notepad.model.Notes;
import com.example.Notepad.model.SuccessMessage;

import java.util.List;

public interface NoteService {
    Notes saveNotes(Notes notes);

    List<Notes> getAllNotes();

    Notes updateNote(Long id,Notes notes) throws Exception;

    SuccessMessage deleteNoteById(Long noteID);
}
