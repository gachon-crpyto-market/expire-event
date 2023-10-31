package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@Document("history")
public class History {

    @Id
    @Field(name = "_id", targetType = FieldType.OBJECT_ID)
    private String id;

    @Field(name = "user_id")
    private Long userId;

    @Field(name = "bid_history")
    private List<BidHistory> bidHistories = new ArrayList<>();

    @Field(name = "ask_history")
    private List<AskHistory> askHistories = new ArrayList<>();

    public void updateBidHistory(BidHistory bidHistory) {
        bidHistories.add(bidHistory);
    }

    public void updateAskHistory(AskHistory askHistory) {
        askHistories.add(askHistory);
    }
}
