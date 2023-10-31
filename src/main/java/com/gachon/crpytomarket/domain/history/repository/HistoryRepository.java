package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {

    History findByUserId(Long userId);
}
