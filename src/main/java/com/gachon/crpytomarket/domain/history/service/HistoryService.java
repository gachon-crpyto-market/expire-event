package com.gachon.crpytomarket.domain.history.service;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryDto;
import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.entity.AskHistory;
import com.gachon.crpytomarket.domain.history.entity.BidHistory;
import com.gachon.crpytomarket.domain.history.entity.History;
import com.gachon.crpytomarket.domain.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public String saveHistory(SaveHistoryRequestDto request) {
        request.getData().forEach(this::saveEachHistory);
        return "hi";
    }

    private void saveEachHistory(SaveHistoryDto request) {
        History buyerHistory = getBuyerHistory(request.getBuyerId());
        History sellerHistory = getSellerHistory(request.getSellerId());

        updateBuyerHistory(buyerHistory, request);
        updateSellerHistory(sellerHistory, request);
    }

    private void updateBuyerHistory(History buyerHistory, SaveHistoryDto request) {
        BidHistory bidHistory = BidHistory.createBidHistory(request);
        buyerHistory.updateBidHistory(bidHistory);
    }

    private void updateSellerHistory(History sellerHistory, SaveHistoryDto request) {
        AskHistory askHistory = AskHistory.createAskHistory(request);
        sellerHistory.updateAskHistory(askHistory);
    }

    public History getBuyerHistory(Long buyerId) {
        return historyRepository.findByUserId(buyerId);
    }

    public History getSellerHistory(Long sellerId) {
        return historyRepository.findByUserId(sellerId);
    }
}
