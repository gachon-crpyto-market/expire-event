package com.gachon.crpytomarket.domain.history.service;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.dto.response.FindUserAllHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.RecentTradeHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.entity.History;
import com.gachon.crpytomarket.domain.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    public String saveHistory(SaveHistoryRequestDto request) {
        saveBidHistory(request);
        saveAskHistory(request);

        return "바껴라 얍";
    }

    public List<FindUserAllHistoryResponseDto> findAllUserHistories(String userId) {
        List<History> userHistories = getUserHistories(userId);

        return userHistories.stream()
                .map(FindUserAllHistoryResponseDto::of)
                .collect(Collectors.toList());
    }

    public List<RecentTradeHistoryResponseDto> getRecentHistories() {
        List<History> histories = getRecentTradePrices();
        return histories.stream()
                .map(RecentTradeHistoryResponseDto::of)
                .collect(Collectors.toList());
    }

//    public List<>

    private List<History> getRecentTradePrices() {
        return historyRepository.findRecentTradePrices();
    }

    private void saveBidHistory(SaveHistoryRequestDto request) {
        History bidHistory = History.createBidHistory(request);
        historyRepository.save(bidHistory);
    }

    private void saveAskHistory(SaveHistoryRequestDto request) {
        History askHistory = History.createAskHistory(request);
        historyRepository.save(askHistory);
    }

    private List<History> getUserHistories(String userId) {
        return historyRepository.findAllByUserIdOrderByTimestampDesc(userId);
    }

}
