package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.Order;
import com.PokeTruck.Backend.Repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 주문 생성
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // 주문 조회 (ID로 조회)
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + orderId));
    }

    // 특정 사용자(userId)의 주문 조회
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    // 특정 날짜(dayCount)의 주문 조회
    public List<Order> getOrdersByDayCount(Integer dayCount) {
        return orderRepository.findByDayCount(dayCount);
    }

    // 주문 상태 업데이트
    public Order updateOrderStatus(Integer orderId, Order.OrderStatus status) {
        Order order = getOrderById(orderId); // 예외 처리 포함
        order.setOrderStatus(status);

        // 성공 상태일 경우, 보상 계산
        if (status == Order.OrderStatus.SUCCESS) {
            int reward = order.getOrderPrice();
            order.setReward(reward);
        } else if (status == Order.OrderStatus.FAILURE) {
            order.setReward(0);
        }

        return orderRepository.save(order);
    }
}
