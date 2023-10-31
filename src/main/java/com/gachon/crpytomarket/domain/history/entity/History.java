package com.gachon.crpytomarket.domain.history.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Document("history")
public class History {

    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    private String id;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "bid_history")
    private List<BidHistory> bidHistories = new ArrayList<>();

    @Field(name = "ask_history")
    private List<AskHistory> askHistories =  new ArrayList<>();

    public void updateBidHistory(BidHistory bidHistory) {
        this.bidHistories.add(bidHistory);
    }

    public void updateAskHistory(AskHistory askHistory) {
        this.askHistories.add(askHistory);
    }

    public static History of(String userId) {
        return History.builder()
                .userId(userId)
                .bidHistories(new ArrayList<>())
                .askHistories(new ArrayList<>())
                .build();
    }
}
