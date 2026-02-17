package com.vidyayatan.whiteboard.whiteboard.repository;

import com.vidyayatan.whiteboard.whiteboard.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Custom query method: find all notes by board ID
    List<Note> findByBoardId(Long boardId);

    // Optional: find all notes by user ID
    List<Note> findByUserId(Long userId);
}