package com.gachon.crpytomarket.domain.history.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IlBongResponseDto {

    private Integer open;

    private Integer high;

    private Integer low;

    private Integer close;

    public static IlBongResponseDto of(Integer open, Integer high, Integer low, Integer close) {
        return IlBongResponseDto.builder()
                .open(open)
                .high(high)
                .low(low)
                .close(close)
                .build();
    }
}
