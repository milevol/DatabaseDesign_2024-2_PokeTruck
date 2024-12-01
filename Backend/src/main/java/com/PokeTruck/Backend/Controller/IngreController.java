package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.Ingre;  // 이 부분 추가
import com.PokeTruck.Backend.Service.IngreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class IngreController {

    private final IngreService ingreService;

    @Autowired
    public IngreController(IngreService ingreService) {
        this.ingreService = ingreService;
    }

    // 사용자 ID로 재료 목록 조회
    @GetMapping("/{userId}/ingredients")
    public List<Ingre> getIngreByUserId(@PathVariable Integer userId) {
        return ingreService.getIngreByUserId(userId);
    }

    // 재료 구매 및 조회 (잠금 해제)
    @PostMapping("/{userId}/purchase/{ingreId}")
    public String purchaseIngre(@PathVariable Integer userId, @PathVariable Integer ingreId) {
        return ingreService.purchaseAndGetIngreByUserId(userId, ingreId);
    }
}
