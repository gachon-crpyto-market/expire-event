package com.gachon.crpytomarket.domain.history.controller;

import com.gachon.crpytomarket.domain.history.dto.request.CreateUserHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.dto.response.FindUserAllHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.GetLastTenDaysResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.RecentTradeHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/histories")
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/test")
    public String testString(){
        return "바껴라 얍!!!!!";
    }

    @PostMapping
    public String saveHistory(@RequestBody SaveHistoryRequestDto request) {
        return historyService.saveHistory(request);
    }

    @GetMapping
    public List<FindUserAllHistoryResponseDto> findUserHistories(@RequestParam String userId) {
        return historyService.findAllUserHistories(userId);
    }

    @GetMapping("/recent")
    public List<RecentTradeHistoryResponseDto> getRecentHistories() {
        return historyService.getRecentHistories();
    }

//    @GetMapping("/day-histories")
//    public List<GetLastTenDaysResponseDto> getDayHistories()

//    @PostMapping("/new-user")
//    public String createUserHistory(@RequestBody CreateUserHistoryRequestDto request) {
//        return historyService.createUserHistory(request);
//    }

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
