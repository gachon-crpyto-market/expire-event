package com.gachon.crpytomarket.domain.history.dto.response;


import com.gachon.crpytomarket.domain.history.entity.History;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecentTradeHistoryResponseDto {

    private Integer price;

    public static RecentTradeHistoryResponseDto of(History history) {
        return RecentTradeHistoryResponseDto.builder()
                .price(history.getPrice())
                .build();
    }
}
