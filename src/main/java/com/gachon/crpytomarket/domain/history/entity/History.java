package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Builder
@Document("history")
public class History {

    @Id
    private String historyId;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "trade_type")
    private String tradeType;

    @Field(name = "counter_user_id")
    private String counterUserId;

    @Field(name = "price")
    private Integer price;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "timestamp")
    private Date timestamp;


    public static History createBidHistory(SaveHistoryRequestDto request) {
        return History.builder()
                .userId(request.getBuyerId())
                .tradeType("매도")
                .counterUserId(request.getSellerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }

    public static History createAskHistory(SaveHistoryRequestDto request) {
        return History.builder()
                .userId(request.getSellerId())
                .tradeType("매수")
                .counterUserId(request.getBuyerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }
}
