package com.example.newsportalapi.service;

import com.example.newsportalapi.dto.NewsDto;

import java.util.List;

public interface NewsService {
    List<NewsDto> getAllNews();
}
