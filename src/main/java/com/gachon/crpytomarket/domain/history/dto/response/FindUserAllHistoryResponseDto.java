package com.gachon.crpytomarket.domain.history.dto.response;


import com.gachon.crpytomarket.domain.history.entity.History;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class FindUserAllHistoryResponseDto {

    private String userId;

    private String tradeType;

    private String counterUserId;

    private Integer price;

    private Integer quantity;

    private Date timestamp;

    public static FindUserAllHistoryResponseDto of(History history) {
        return FindUserAllHistoryResponseDto.builder()
                .userId(history.getUserId())
                .tradeType(history.getTradeType())
                .counterUserId(history.getCounterUserId())
                .price(history.getPrice())
                .quantity(history.getQuantity())
                .timestamp(history.getTimestamp())
                .build();
    }
}
