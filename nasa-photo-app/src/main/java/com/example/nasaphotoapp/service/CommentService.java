package com.example.nasaphotoapp.service;

import com.example.nasaphotoapp.model.Comment;
import com.example.nasaphotoapp.model.Photo;
import com.example.nasaphotoapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByPhoto(Photo photo) {
        return commentRepository.findByPhoto(photo);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void likeComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.like();
        commentRepository.save(comment);
    }
}
