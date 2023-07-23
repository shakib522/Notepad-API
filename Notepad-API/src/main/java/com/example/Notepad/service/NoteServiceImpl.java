package com.example.Notepad.service;

import com.example.Notepad.model.Notes;
import com.example.Notepad.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository repository;
    @Override
    public Notes saveNotes(Notes notes) {
        return repository.save(notes);
    }
}
