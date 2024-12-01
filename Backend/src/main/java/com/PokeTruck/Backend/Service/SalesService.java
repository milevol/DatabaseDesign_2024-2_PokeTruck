package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Sales;
import com.PokeTruck.Backend.Repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    // 특정 날짜에 대한 매출 조회
    public Integer getSalesByDay(Integer dayCount) {
        return salesRepository.findTotalSalesByDay(dayCount).orElse(0);
    }

    // 특정 사용자의 총 매출 조회
    public Integer getTotalSalesByUser(Integer userId) {
        return salesRepository.findTotalSalesByUser(userId).orElse(0);
    }

    // 매출 업데이트
    public void updateSales(Integer userId, Integer dayCount, Integer amount) {
        Sales sales = salesRepository.findByUserIdAndDayCount(userId, dayCount)
                .orElse(new Sales(null, userId, dayCount, 0));
        sales.setDaySales(sales.getDaySales() + amount);
        salesRepository.save(sales);
    }

    // 모든 매출 정보 조회
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    // 특정 날짜에 대한 총 매출 조회
    public Integer getTotalSalesByDay(Integer dayCount) {
        return salesRepository.findTotalSalesByDay(dayCount).orElse(0);
    }
}
