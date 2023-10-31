package com.gachon.crpytomarket.domain.history.entity;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryDto;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Builder
public class AskHistory {
    @Id
    private ObjectId fixedDepositId;

    @Field(name = "buyer_id")
    private Long buyerId;

    @Field(name = "price")
    private Integer price;

    @Field(name = "quantity")
    private Integer quantity;

    @CreatedDate
    @Field(name = "timestamp")
    private Date timestamp;

    public static AskHistory createAskHistory(SaveHistoryDto request) {
        return AskHistory.builder()
                .buyerId(request.getBuyerId())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .timestamp(request.getTimestamp())
                .build();
    }

}
