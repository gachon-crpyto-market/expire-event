package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Builder
@Document("bid_history")
public class BidHistory {

    @Id
    private String fixedDepositId;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "seller_id")
    private String sellerId;

    @Field(name = "price")
    private Integer price;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "timestamp")
    private Date timestamp;

    public static BidHistory createBidHistory(SaveHistoryRequestDto request) {
        return BidHistory.builder()
                .userId(request.getBuyerId())
                .sellerId(request.getSellerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }
}
