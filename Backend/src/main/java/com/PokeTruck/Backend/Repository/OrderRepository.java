package com.PokeTruck.Backend.Repository;

import com.PokeTruck.Backend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(Integer userId);

    List<Order> findByUserIdAndOrderStatus(Integer userId, Order.OrderStatus orderStatus);

    List<Order> findByDayCount(Integer dayCount);

    List<Order> findByPkmId(Integer pkmId);
}
