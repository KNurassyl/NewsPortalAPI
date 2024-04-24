package com.example.newsportalapi.repository;

import com.example.newsportalapi.dto.RequestDto;
import com.example.newsportalapi.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
