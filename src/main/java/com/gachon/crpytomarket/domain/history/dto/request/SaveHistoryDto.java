package com.gachon.crpytomarket.domain.history.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class SaveHistoryDto {
    private Long buyerId;

    private Long sellerId;

    private Integer price;

    private Integer quantity;

    private Date timestamp;
}
