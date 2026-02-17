package com.vidyayatan.whiteboard.whiteboard.controller;

import com.vidyayatan.whiteboard.whiteboard.model.Board;
import com.vidyayatan.whiteboard.whiteboard.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardRepository repo;

    public BoardController(BoardRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Board> getAllBoards() {
        return repo.findAll();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return repo.save(board);
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board updatedBoard) {
        return repo.findById(id).map(board -> {
            board.setTitle(updatedBoard.getTitle());
            board.setNotes(updatedBoard.getNotes());
            return repo.save(board);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        repo.deleteById(id);
        return "Board deleted successfully!";
    }

    // NEW endpoint: fetch all notes for a given board
    @GetMapping("/{id}/notes")
    public List<com.vidyayatan.whiteboard.whiteboard.model.Note> getNotesForBoard(@PathVariable Long id) {
        return repo.findById(id)
                .map(Board::getNotes)
                .orElse(List.of());
    }
}