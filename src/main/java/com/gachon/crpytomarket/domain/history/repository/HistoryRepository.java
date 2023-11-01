package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import com.gachon.crpytomarket.domain.history.entity.History;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoryRepository extends MongoRepository<History, String> {

    List<History> findAllByUserIdOrderByTimestampDesc(String userId);


}
