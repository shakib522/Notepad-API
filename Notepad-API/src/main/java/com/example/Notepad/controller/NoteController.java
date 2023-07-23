package com.example.Notepad.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World From Note App";
    }
}
