package com.example.Notepad.controller;

import com.example.Notepad.error.DefaultException;
import com.example.Notepad.model.Notes;
import com.example.Notepad.service.NoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/notes")
    public Notes saveNote(@RequestBody Notes notes) throws DefaultException {
        return noteService.saveNotes(notes);
    }

    @GetMapping("/notes")
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PutMapping("/notes/{id}")
    public Notes updateNotes(
            @PathVariable("id") Long noteId,
            @RequestBody Notes note
    ) throws DefaultException {
        return noteService.updateNote(noteId, note);
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNoteById(@PathVariable("id") Long noteID) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(noteService.deleteNoteById(noteID));
    }

    @GetMapping("/notes/type/{type}")
    public List<Notes> getAllByType(@PathVariable("type") String type) {
        return noteService.getAllByType(type);
    }

}
