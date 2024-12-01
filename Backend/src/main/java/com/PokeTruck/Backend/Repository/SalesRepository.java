package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

    // 특정 사용자의 총 매출 조회
    Optional<Integer> findTotalSalesByUserId(Integer userId);

    // 특정 사용자와 날짜에 대한 매출 조회
    Optional<Sales> findByUserIdAndDayCount(Integer userId, Integer dayCount);

    List<Sales> findByUserId(Integer userId);

    Optional<Integer> findTotalSalesByDayCount(Integer dayCount);
}
