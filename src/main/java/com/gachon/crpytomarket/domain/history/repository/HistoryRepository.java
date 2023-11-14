package com.gachon.crpytomarket.domain.history.repository;

import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import com.gachon.crpytomarket.domain.history.entity.History;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HistoryRepository extends MongoRepository<History, String> {

    List<History> findAllByUserIdOrderByTimestampDesc(String userId);

    @Aggregation(pipeline = {
            "{ '$match': { 'trade_type' : 매수 } }",
            "{ '$sort' : { 'timestamp' : -1 } }",
            "{ '$limit' : 30 }"
    })
    List<History> findRecentTradePrices();

}
