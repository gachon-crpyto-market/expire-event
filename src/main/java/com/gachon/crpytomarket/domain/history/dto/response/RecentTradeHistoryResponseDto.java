package com.gachon.crpytomarket.domain.history.dto.response;


import com.gachon.crpytomarket.domain.history.entity.History;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class RecentTradeHistoryResponseDto {

    private Integer price;

    private Date timestamp;

    public static RecentTradeHistoryResponseDto of(History history) {
        return RecentTradeHistoryResponseDto.builder()
                .price(history.getPrice())
                .timestamp(history.getTimestamp())
                .build();
    }
}
