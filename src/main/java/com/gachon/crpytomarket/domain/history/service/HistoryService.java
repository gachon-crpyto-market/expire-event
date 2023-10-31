package com.gachon.crpytomarket.domain.history.service;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import com.gachon.crpytomarket.domain.history.entity.BidHistory;
import com.gachon.crpytomarket.domain.history.repository.AskHistoryRepository;
import com.gachon.crpytomarket.domain.history.repository.BidHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final BidHistoryRepository bidHistoryRepository;
    private final AskHistoryRepository askHistoryRepository;

    public String saveHistory(SaveHistoryRequestDto request) {
        saveBidHistory(request);
        saveAskHistory(request);

        return "hi";
    }

    private void saveBidHistory(SaveHistoryRequestDto request) {
        BidHistory bidHistory = BidHistory.createBidHistory(request);
        bidHistoryRepository.save(bidHistory);
    }

    private void saveAskHistory(SaveHistoryRequestDto request) {
        AskHistory askHistory = AskHistory.createAskHistory(request);
        askHistoryRepository.save(askHistory);
    }

}
