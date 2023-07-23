package com.example.Notepad.service;

import com.example.Notepad.model.Notes;

import java.util.List;

public interface NoteService {
    Notes saveNotes(Notes notes);

    List<Notes> getAllNotes();

    Notes updateNote(Long id,Notes notes);
}
