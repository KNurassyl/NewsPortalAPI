package com.example.newsportalapi.service.impl;

import com.example.newsportalapi.customException.DatabaseException;
import com.example.newsportalapi.dto.RequestDto;
import com.example.newsportalapi.dto.RequestMapper;
import com.example.newsportalapi.model.Request;
import com.example.newsportalapi.repository.RequestRepository;
import com.example.newsportalapi.service.RequestService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    public RequestServiceImpl(RequestRepository requestRepository, RequestMapper requestMapper) {
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
    }

    @Override
    public RequestDto createRequest(RequestDto requestDto) {
        validateRequestDto(requestDto);

        Request newRequest = new Request();
        newRequest.setProduct(requestDto.getProduct());
        newRequest.setQuantity(requestDto.getQuantity());
        newRequest.setDeliveryAddress(requestDto.getDeliveryAddress());
        newRequest.setPhoneNumber(requestDto.getPhoneNumber());

        Request savedRequest;
        try {
            savedRequest = requestRepository.save(newRequest);
        } catch (DataAccessException ex) {
            throw new DatabaseException("Failed to save the request to the database", ex);
        }

        return requestMapper.toDto(savedRequest);
    }


    private void validateRequestDto(RequestDto requestDto) {
        if (requestDto.getProduct() == null || requestDto.getProduct().isEmpty()) {
            throw new IllegalArgumentException("Product cannot be null or empty");
        }
        if (requestDto.getQuantity() == null || requestDto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }


}
