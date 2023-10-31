package com.gachon.crpytomarket.domain.history.dto.request;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class SaveHistoryRequestDto {

    private List<SaveHistoryDto> data;

}
