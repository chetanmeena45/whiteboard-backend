package com.vidyayatan.whiteboard.whiteboard.repository;

import com.vidyayatan.whiteboard.whiteboard.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}