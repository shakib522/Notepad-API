package com.example.Notepad.service;

import com.example.Notepad.error.DefaultException;
import com.example.Notepad.model.Notes;
import com.example.Notepad.model.SuccessMessage;
import com.example.Notepad.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository repository;
    @Override
    public Notes saveNotes(Notes notes)throws DefaultException {
        if(notes.getType()==null || notes.getTitle()==null || notes.getNote()==null){
            throw new DefaultException("Please provide all the details", HttpStatus.BAD_REQUEST);
        }
        return repository.save(notes);
    }

    @Override
    public List<Notes> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Notes updateNote(Long id,Notes notes) throws DefaultException {
        Notes notesFromDB=repository.findById(id).get();
        if(notes.getType()==null || notes.getTitle()==null || notes.getNote()==null){
            throw new DefaultException("Please provide all the details", HttpStatus.BAD_REQUEST);
        }
        notesFromDB.setNote(notes.getNote());
        if(notes.getTitle()!=null){
            notesFromDB.setTitle(notes.getTitle());
        }
        if (notes.getType()!=null){
            notesFromDB.setType(notes.getType());
        }
        return repository.save(notesFromDB);
    }

    @Override
    public SuccessMessage deleteNoteById(Long noteID) {
        try {
            repository.deleteById(noteID);
        }catch (Exception e) {
            e.printStackTrace();
        }
         return new SuccessMessage("success","Note Deleted Successfully");
    }

    @Override
    public List<Notes> getAllByType(String type) {
        return repository.findByType(type);
    }
}
