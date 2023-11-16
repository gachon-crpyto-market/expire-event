package com.gachon.crpytomarket.domain.history.dto.response;


import com.gachon.crpytomarket.domain.history.entity.History;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Builder
public class GetLastTenDaysResponseDto {

    private List<DayHistoryResponseDto> dayHistory;

    @Getter
    @Builder
    public static class DayHistoryResponseDto {

        private String date;

        private Integer highestPrice;

        private Integer lowestPrice;

        private Integer startPrice;

        private Integer endPrice;

        public static DayHistoryResponseDto of(LocalDate date,
                                               Integer highestPrice,
                                               Integer lowestPrice,
                                               Integer startPrice,
                                               Integer endPrice) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MMM.dd");

            // 날짜를 원하는 형식으로 포맷팅
            String formattedDate = date.format(formatter);
            return DayHistoryResponseDto.builder()
                    .date(formattedDate)
                    .highestPrice(highestPrice)
                    .lowestPrice(lowestPrice)
                    .startPrice(startPrice)
                    .endPrice(endPrice)
                    .build();
        }
    }
}
