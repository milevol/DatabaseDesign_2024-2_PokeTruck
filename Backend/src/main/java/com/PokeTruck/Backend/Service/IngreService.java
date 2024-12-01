package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Ingre;
import com.PokeTruck.Backend.Entity.User;
import com.PokeTruck.Backend.Repository.IngreRepository;
import com.PokeTruck.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngreService {

    private final IngreRepository ingreRepository;
    private final UserRepository userRepository;  // 사용자 정보를 확인할 UserRepository 추가

    @Autowired
    public IngreService(IngreRepository ingreRepository, UserRepository userRepository) {
        this.ingreRepository = ingreRepository;
        this.userRepository = userRepository;
    }

    // 사용자 ID에 맞는 재료 목록 조회
    public List<Ingre> getIngreByUserId(Integer userId) {
        return ingreRepository.findByUserId(userId);
    }

    // 재료 구매 및 잠금 해제
    public String purchaseAndGetIngreByUserId(Integer userId, Integer ingreId) {
        // 재료 정보 가져오기
        Ingre ingre = ingreRepository.findById(ingreId)
                .orElseThrow(() -> new RuntimeException("재료를 찾을 수 없습니다."));

        // 이미 잠금이 해제된 재료일 경우
        if (ingre.getIsUnlocked() == 1) {
            return "이미 잠금이 해제된 재료입니다.";
        }

        // 사용자의 돈 확인
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        int userMoney = user.getMoney();  // 사용자의 소지금
        int ingreCost = ingre.getIngreCost();  // 재료 가격

        // 돈이 부족한 경우
        if (userMoney < ingreCost) {
            return "사용자의 돈이 부족합니다. 재료를 구매할 수 없습니다.";
        }

        // 재료 잠금 해제
        ingre.setIsUnlocked(1);  // 잠금 해제
        ingreRepository.save(ingre);

        // 사용자 소지금 차감
        user.setMoney(userMoney - ingreCost);  // 차감
        userRepository.save(user);  // 저장

        return "재료 구매 및 잠금 해제 완료!";
    }
}
