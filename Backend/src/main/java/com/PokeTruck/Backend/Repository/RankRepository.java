package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, Integer> {

    // userId로 Rank 찾기
    Optional<Rank> findByUserId(Integer userId);
}
