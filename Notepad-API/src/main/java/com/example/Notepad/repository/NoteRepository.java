package com.example.Notepad.repository;

import com.example.Notepad.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Notes,Long> {

    List<Notes> findByType(String type);
}
