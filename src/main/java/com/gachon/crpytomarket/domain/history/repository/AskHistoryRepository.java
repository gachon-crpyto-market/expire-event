package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AskHistoryRepository extends MongoRepository<AskHistory, String> {

    List<AskHistory> findAllByUserId(String userId);


}
