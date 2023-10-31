package com.gachon.crpytomarket.domain.history.controller;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/histories")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping
    public String saveHistory(@RequestBody SaveHistoryRequestDto request) {
        return historyService.saveHistory(request);
    }

//    public String getAskHistory() {
//
//    }
//
//    public String getBidHistory() {
//
//    }
//
//    public String getAllHistory() {
//
//    }
}
