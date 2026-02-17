package com.vidyayatan.whiteboard.whiteboard.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // One board can have many notes
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Note> notes;
}