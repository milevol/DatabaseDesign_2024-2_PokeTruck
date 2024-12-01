package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Rank;
import com.PokeTruck.Backend.Entity.Sales;
import com.PokeTruck.Backend.Repository.RankRepository;
import com.PokeTruck.Backend.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private RankRepository rankRepository;

    // 특정 사용자의 총 매출을 계산하는 메서드
    public void calculateTotalSalesForUser(Integer userId) {
        // 사용자의 모든 Sales 데이터를 조회
        List<Sales> salesList = salesRepository.findByUserId(userId);

        // 사용자의 총 매출 계산
        double totalSales = salesList.stream()
                .mapToDouble(Sales::getDaySales) // daySales의 값을 더함
                .sum();

        // Rank 엔티티가 이미 존재하면 업데이트, 없으면 새로 생성
        Optional<Rank> existingRank = rankRepository.findByUserId(userId);
        Rank rank;
        if (existingRank.isPresent()) {
            // 기존 Rank 객체가 있으면 업데이트
            rank = existingRank.get();
            rank.setTotalSales((int) totalSales); // double을 int로 변환하여 설정
        } else {
            // 기존 Rank 객체가 없으면 새로 생성
            rank = new Rank();
            rank.setUserId(userId);
            rank.setTotalSales((int) totalSales); // double을 int로 변환하여 설정
        }

        // 순위 계산: 총 매출 내림차순으로 순위를 매김
        List<Rank> allRanks = rankRepository.findAll();
        allRanks.sort((r1, r2) -> Integer.compare(r2.getTotalSales(), r1.getTotalSales()));  // 내림차순 정렬

        // 순위 계산 후 저장
        int ranking = allRanks.indexOf(rank) + 1;  // 순위는 1부터 시작
        rank.setRanking(ranking);

        // Rank 테이블에 저장
        rankRepository.save(rank);
    }

    // 순위별로 총 매출 내림차순 정렬해서 반환
    public List<Rank> getRanksOrderedByTotalSales() {
        List<Rank> ranks = rankRepository.findAll();
        ranks.sort((r1, r2) -> Integer.compare(r2.getTotalSales(), r1.getTotalSales()));  // 총 매출 내림차순 정렬
        return ranks;
    }
}
