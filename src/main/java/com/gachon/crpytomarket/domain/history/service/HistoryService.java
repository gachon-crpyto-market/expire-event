package com.gachon.crpytomarket.domain.history.service;

import com.gachon.crpytomarket.domain.history.dto.request.SaveHistoryRequestDto;
import com.gachon.crpytomarket.domain.history.dto.response.FindUserAllHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.IlBongResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.IlBongVolumeResponseDto;
import com.gachon.crpytomarket.domain.history.dto.response.RecentTradeHistoryResponseDto;
import com.gachon.crpytomarket.domain.history.entity.History;
import com.gachon.crpytomarket.domain.history.repository.HistoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private static List<IlBongResponseDto> ilBongLists = new ArrayList<>();
    private static List<IlBongVolumeResponseDto> ilBongVolumes = new ArrayList<>();



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

    public List<IlBongResponseDto> getIlBongData() {
        return ilBongLists;
    }

    public List<IlBongVolumeResponseDto> getIlBongVolumeData() {
        return ilBongVolumes;
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



    @PostConstruct
    private void createIlBongData() {
        ilBongLists.add(IlBongResponseDto.of(907,912,904,908));
        ilBongLists.add(IlBongResponseDto.of(911,920,911,918));
        ilBongLists.add(IlBongResponseDto.of(908,913,900,905));
        ilBongLists.add(IlBongResponseDto.of(910,914,907,908));
        ilBongLists.add(IlBongResponseDto.of(917,919,915,916));
        ilBongLists.add(IlBongResponseDto.of(919,923,906,911));
        ilBongLists.add(IlBongResponseDto.of(904,908,904,904));
        ilBongLists.add(IlBongResponseDto.of(895,905,890,900));
        ilBongLists.add(IlBongResponseDto.of(907,916,902,913));
        ilBongLists.add(IlBongResponseDto.of(906,909,906,909));
        ilBongLists.add(IlBongResponseDto.of(911,920,911,920));
        ilBongLists.add(IlBongResponseDto.of(930,938,927,934));
        ilBongLists.add(IlBongResponseDto.of(928,936,924,933));
        ilBongLists.add(IlBongResponseDto.of(938,941,931,931));
        ilBongLists.add(IlBongResponseDto.of(939,940,931,934));
        ilBongLists.add(IlBongResponseDto.of(933,937,926,928));
        ilBongLists.add(IlBongResponseDto.of(919,927,916,924));
        ilBongLists.add(IlBongResponseDto.of(915,919,914,918));
        ilBongLists.add(IlBongResponseDto.of(911,922,907,921));
        ilBongLists.add(IlBongResponseDto.of(918,923,913,913));
        ilBongLists.add(IlBongResponseDto.of(923,933,919,931));
        ilBongLists.add(IlBongResponseDto.of(927,928,915,918));
        ilBongLists.add(IlBongResponseDto.of(926,932,926,928));
        ilBongLists.add(IlBongResponseDto.of(924,926,923,923));
        ilBongLists.add(IlBongResponseDto.of(922,926,913,917));
        ilBongLists.add(IlBongResponseDto.of(915,916,900,905));
        ilBongLists.add(IlBongResponseDto.of(904,909,895,900));
        ilBongLists.add(IlBongResponseDto.of(907,919,903,915));
        ilBongLists.add(IlBongResponseDto.of(912,921,909,918));
        ilBongLists.add(IlBongResponseDto.of(910,913,900,902));
        ilBongLists.add(IlBongResponseDto.of(904,913,903,909));
        ilBongLists.add(IlBongResponseDto.of(902,914,899,909));
        ilBongLists.add(IlBongResponseDto.of(905,916,903,915));
        ilBongLists.add(IlBongResponseDto.of(915,920,915,917));
        ilBongLists.add(IlBongResponseDto.of(908,912,902,906));
        ilBongLists.add(IlBongResponseDto.of(911,916,899,902));
        ilBongLists.add(IlBongResponseDto.of(909,912,905,912));
        ilBongLists.add(IlBongResponseDto.of(916,921,911,912));
        ilBongLists.add(IlBongResponseDto.of(907,917,904,917));
        ilBongLists.add(IlBongResponseDto.of(911,917,908,917));
        ilBongLists.add(IlBongResponseDto.of(925,940,924,935));
        ilBongLists.add(IlBongResponseDto.of(939,940,935,935));
        ilBongLists.add(IlBongResponseDto.of(937,941,928,928));
        ilBongLists.add(IlBongResponseDto.of(923,933,922,929));
        ilBongLists.add(IlBongResponseDto.of(919,922,917,922));
        ilBongLists.add(IlBongResponseDto.of(922,932,918,929));
        ilBongLists.add(IlBongResponseDto.of(923,928,909,914));
        ilBongLists.add(IlBongResponseDto.of(921,931,916,931));
        ilBongLists.add(IlBongResponseDto.of(937,949,936,946));
        ilBongLists.add(IlBongResponseDto.of(948,951,941,946));

        ilBongVolumes.add(IlBongVolumeResponseDto.of(152));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(123));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(146));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(162));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(183));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(141));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(101));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(110));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(157));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(195));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(123));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(160));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(178));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(196));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(162));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(118));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(171));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(180));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(168));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(188));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(162));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(155));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(128));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(146));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(134));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(156));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(140));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(120));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(146));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(178));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(179));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(152));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(163));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(180));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(168));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(158));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(143));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(179));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(137));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(145));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(186));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(179));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(145));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(132));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(156));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(142));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(178));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(146));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(165));
        ilBongVolumes.add(IlBongVolumeResponseDto.of(169));
    }

}
