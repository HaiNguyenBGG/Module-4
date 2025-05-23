package com.example.nasaphotoapp.controller;

import com.example.nasaphotoapp.model.Comment;
import com.example.nasaphotoapp.model.Photo;
import com.example.nasaphotoapp.service.CommentService;
import com.example.nasaphotoapp.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PhotoController {
    private final PhotoService photoService;
    private final CommentService commentService;

    public PhotoController(PhotoService photoService, CommentService commentService) {
        this.photoService = photoService;
        this.commentService = commentService;
    }

    @GetMapping
    public String index(Model model) {
        Photo photo = photoService.getPhotoOfTheDay();
        List<Comment> comments = commentService.getCommentsByPhoto(photo);
        model.addAttribute("photo", photo);
        model.addAttribute("comments", comments);
        return "photo";
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam String author, @RequestParam String content, @RequestParam int rating) {
        Photo photo = photoService.getPhotoOfTheDay();
        Comment comment = new Comment(author, content, rating, photo);
        commentService.saveComment(comment);
        return "redirect:/";
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable Long id) {
        commentService.likeComment(id);
        return "redirect:/";
    }
}
