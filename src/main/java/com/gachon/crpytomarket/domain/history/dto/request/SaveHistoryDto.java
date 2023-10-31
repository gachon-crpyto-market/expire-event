package com.gachon.crpytomarket.domain.history.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class SaveHistoryDto {
    private String buyerId;

    private String sellerId;

    private Integer price;

    private Integer quantity;

    private Date timestamp;
}
