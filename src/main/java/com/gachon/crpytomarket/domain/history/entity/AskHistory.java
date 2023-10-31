package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Builder
@Document("ask_history")
public class AskHistory {

    @Id
    private String fixedDepositId;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "buyer_id")
    private String buyerId;

    @Field(name = "price")
    private Integer price;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "timestamp")
    private Date timestamp;

    public static AskHistory createAskHistory(SaveHistoryRequestDto request) {
        return AskHistory.builder()
                .userId(request.getSellerId())
                .buyerId(request.getBuyerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }

}
