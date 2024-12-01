package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByUserId(Integer userId); // userId로 메뉴 검색
}
