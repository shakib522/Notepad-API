package com.example.Notepad.service;

import com.example.Notepad.error.DefaultException;
import com.example.Notepad.model.Notes;
import com.example.Notepad.model.SuccessMessage;

import java.util.List;

public interface NoteService {
    Notes saveNotes(Notes notes) throws DefaultException;

    List<Notes> getAllNotes();

    Notes updateNote(Long id,Notes notes) throws DefaultException;

    SuccessMessage deleteNoteById(Long noteID);

    List<Notes> getAllByType(String type);
}
