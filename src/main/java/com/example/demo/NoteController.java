package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    // Get All Notes

    // Create a new Note

    // Get a Single Note

    // Update a Note

    // Delete a Note
    
 // Get All Notes
    @GetMapping("/notes1")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    
    // Create a new Note
    @PostMapping("/notes1")
    public Note createNote( @RequestBody Note note) {
        return noteRepository.save(note);
    }
    
    @DeleteMapping("/notes1/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.deleteById(noteId);

        return ResponseEntity.ok().build();
    }
    
 // Update a Note
    @PutMapping("/notes1/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                             @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }
    
    
    
}