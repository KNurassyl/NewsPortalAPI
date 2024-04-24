package com.example.newsportalapi.controller;

import com.example.newsportalapi.dto.NewsDto;
import com.example.newsportalapi.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<?> getAllNews() {
        List<NewsDto> newsList = newsService.getAllNews();

        if (newsList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The news list is empty");
        }

        return ResponseEntity.ok(newsList);
    }

}
