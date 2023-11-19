package com.gachon.crpytomarket.domain.history.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IlBongVolumeResponseDto {

    private Integer volume;

    public static IlBongVolumeResponseDto of(Integer volume) {
        return IlBongVolumeResponseDto.builder()
                .volume(volume)
                .build();
    }
}
