package com.example.Notepad.controller;

import com.example.Notepad.model.Notes;
import com.example.Notepad.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("/notes")
    public Notes saveNote(@Valid @RequestBody Notes notes){
       return noteService.saveNotes(notes);
    }

}
