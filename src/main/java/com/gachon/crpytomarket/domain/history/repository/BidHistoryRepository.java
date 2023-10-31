package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.BidHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BidHistoryRepository extends MongoRepository<BidHistory, String> {

    List<BidHistory> findAllByUserId(String userId);

}
