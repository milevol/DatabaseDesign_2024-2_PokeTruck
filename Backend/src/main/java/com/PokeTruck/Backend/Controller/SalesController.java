package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.Sales;
import com.PokeTruck.Backend.Service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // 특정 날짜의 총 매출 조회
    @GetMapping("/day/{dayCount}")
    public ResponseEntity<Integer> getTotalSalesByDay(@PathVariable Integer dayCount) {
        Integer totalSales = salesService.getTotalSalesByDay(dayCount);
        return ResponseEntity.ok(totalSales);
    }

    // 특정 사용자의 총 매출 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<Integer> getTotalSalesByUser(@PathVariable Integer userId) {
        Integer totalSales = salesService.getTotalSalesByUser(userId);
        return ResponseEntity.ok(totalSales);
    }

    // 전체 매출 조회
    @GetMapping("/all")
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }

    // 매출 업데이트
    @PutMapping("/update")
    public ResponseEntity<Void> updateSales(
            @RequestParam Integer userId,
            @RequestParam Integer dayCount,
            @RequestParam Integer amount) {
        salesService.updateSales(userId, dayCount, amount);
        return ResponseEntity.ok().build();
    }
}
