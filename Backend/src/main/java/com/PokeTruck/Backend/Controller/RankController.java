package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.Rank;
import com.PokeTruck.Backend.Service.RankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    // 매출을 기준으로 랭킹을 내림차순으로 조회
    @GetMapping("/list")
    public ResponseEntity<List<Rank>> getRankList() {
        List<Rank> ranks = rankService.getRanksOrderedByTotalSales();
        return ResponseEntity.ok(ranks);
    }

    // 총 매출 기준으로 순위를 내림차순 정렬하여 반환
    @GetMapping("/ordered")
    public List<Rank> getRanksOrderedByTotalSales() {
        return rankService.getRanksOrderedByTotalSales();
    }
}
