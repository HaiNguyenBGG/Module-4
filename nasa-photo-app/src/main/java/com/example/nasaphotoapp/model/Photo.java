package com.example.nasaphotoapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private String explanation;
    private LocalDate date;

    @OneToMany(mappedBy = "photo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Photo() {}

    public Photo(String title, String url, String explanation, LocalDate date) {
        this.title = title;
        this.url = url;
        this.explanation = explanation;
        this.date = date;
    }

    // Getters và Setters
}
