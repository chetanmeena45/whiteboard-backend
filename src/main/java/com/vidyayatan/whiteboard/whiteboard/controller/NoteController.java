package com.vidyayatan.whiteboard.whiteboard.controller;

import com.vidyayatan.whiteboard.whiteboard.model.Note;
import com.vidyayatan.whiteboard.whiteboard.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository repo;

    public NoteController(NoteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return repo.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return repo.save(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        return repo.findById(id).map(note -> {
            note.setContent(updatedNote.getContent());
            note.setUser(updatedNote.getUser());
            note.setBoard(updatedNote.getBoard());
            return repo.save(note);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        repo.deleteById(id);
        return "Note deleted successfully!";
    }

    // NEW endpoint: fetch all notes for a given board
    @GetMapping("/board/{boardId}")
    public List<Note> getNotesByBoard(@PathVariable Long boardId) {
        return repo.findByBoardId(boardId);
    }
}