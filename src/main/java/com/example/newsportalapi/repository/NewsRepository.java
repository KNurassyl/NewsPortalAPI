package com.example.newsportalapi.repository;

import com.example.newsportalapi.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}