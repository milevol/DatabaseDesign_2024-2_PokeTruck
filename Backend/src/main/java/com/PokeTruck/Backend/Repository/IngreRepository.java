package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Ingre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngreRepository extends JpaRepository<Ingre, Integer> {

    // 사용자 ID로 재료 목록을 조회
    List<Ingre> findByUserId(Integer userId);
}
