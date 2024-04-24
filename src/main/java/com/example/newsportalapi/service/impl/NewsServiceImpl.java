package com.example.newsportalapi.service.impl;

import com.example.newsportalapi.dto.NewsDto;
import com.example.newsportalapi.model.News;
import com.example.newsportalapi.repository.NewsRepository;
import com.example.newsportalapi.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsDto> getAllNews() {
        List<News> newsList = newsRepository.findAll();

        return newsList.stream()
                .map(news -> {
                    NewsDto dto = new NewsDto();
                    dto.setTitle(news.getTitle());
                    dto.setContent(news.getContent());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
