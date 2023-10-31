package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import com.gachon.crpytomarket.domain.history.entity.BidHistory;
import com.gachon.crpytomarket.domain.history.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AskHistoryRepository extends MongoRepository<AskHistory, String> {

    List<AskHistory> findAllByUserId(String userId);


}
