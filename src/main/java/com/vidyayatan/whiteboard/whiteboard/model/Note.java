package com.vidyayatan.whiteboard.whiteboard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;   // who created the note

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board; // which board this note belongs to
}