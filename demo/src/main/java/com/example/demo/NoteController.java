package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }


    /**
     * Create a new note for a user (ownerId in request).
     */
    @PostMapping
    public Note createNote(@RequestBody Note note, @RequestParam Long ownerId) {
        User owner = new User();
        owner.setId(ownerId);
        note.setOwner(owner);
        return noteRepository.save(note);
    }

    /**
     * Update an existing note (only owner can update).
     */
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote, @RequestParam Long ownerId) {
        Note note = noteRepository.findById(id).orElseThrow();
        if (!note.getOwner().getId().equals(ownerId)) throw new RuntimeException("Unauthorized");
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(note);
    }

    /**
     * Delete a note (only owner can delete).
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id, @RequestParam Long ownerId) {
        Note note = noteRepository.findById(id).orElseThrow();
        if (!note.getOwner().getId().equals(ownerId)) throw new RuntimeException("Unauthorized");
        noteRepository.delete(note);
    }

    @GetMapping("/share/{uuid}")
    public Optional<Note> getNoteByShareUuid(@PathVariable String uuid) {
        return noteRepository.findByShareUuid(uuid);
    }

    // Update and Delete endpoints can be added here
}
