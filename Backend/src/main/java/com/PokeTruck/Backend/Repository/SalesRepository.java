package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

    // 특정 사용자와 날짜의 매출을 조회하는 메서드
    Optional<Sales> findByUserIdAndDayCount(Integer userId, Integer dayCount);

    // 특정 날짜의 총 매출을 조회하는 메서드
    Optional<Integer> findTotalSalesByDay(Integer dayCount);

    // 특정 사용자의 총 매출을 조회하는 메서드
    Optional<Integer> findTotalSalesByUser(Integer userId);

    // 특정 사용자의 모든 Sales 데이터를 조회s
    List<Sales> findByUserId(Integer userId);

    // 주어진 userId에 대해 총 판매액 계산
    @Query("SELECT SUM(s.daySales) FROM Sales s WHERE s.userId = :userId")
    double calculateTotalSalesByUserId(Integer userId);
}
