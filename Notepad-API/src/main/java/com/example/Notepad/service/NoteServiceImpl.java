package com.example.Notepad.service;

import com.example.Notepad.model.Notes;
import com.example.Notepad.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository repository;
    @Override
    public Notes saveNotes(Notes notes) {
        return repository.save(notes);
    }

    @Override
    public List<Notes> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Notes updateNote(Long id,Notes notes) {
        Notes notesFromDB=repository.findById(id).get();
        if(notes.getNote()!=null){
            notesFromDB.setNote(notes.getNote());
        }
        if(notes.getTitle()!=null){
            notesFromDB.setTitle(notes.getTitle());
        }
        if (notes.getType()!=null){
            notesFromDB.setType(notes.getType());
        }
        return repository.save(notesFromDB);
    }
}
