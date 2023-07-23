package com.example.Notepad.controller;

import com.example.Notepad.model.Notes;
import com.example.Notepad.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("/notes")
    public Notes saveNote(@Valid @RequestBody Notes notes){
       return noteService.saveNotes(notes);
    }

    @GetMapping("/notes")
    public List<Notes> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PutMapping("/notes/{id}")
    public Notes updateNotes(
            @PathVariable("id") Long noteId,
            @RequestBody Notes note
    ){
       return noteService.updateNote(noteId,note);
    }

}
