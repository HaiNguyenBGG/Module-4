package com.example.nasaphotoapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String content;
    private int rating;
    private int likes;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    public Comment() {}

    public Comment(String author, String content, int rating, Photo photo) {
        this.author = author;
        this.content = content;
        this.rating = rating;
        this.photo = photo;
        this.likes = 0;
    }

    public void like() {
        this.likes++;
    }

    // Getters và Setters
}
