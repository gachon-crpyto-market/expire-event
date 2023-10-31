package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryDto;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Builder
public class BidHistory {
    @Id
    private ObjectId fixedDepositId;


    @Field(name = "seller_id")
    private String sellerId;

    @Field(name = "price")
    private Integer price;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "timestamp")
    private Date timestamp;

    public static BidHistory createBidHistory(SaveHistoryDto request) {
        return BidHistory.builder()
                .sellerId(request.getSellerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }
}
