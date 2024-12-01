package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`Order`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = false)
    private Integer userId; // FK

    @Column(nullable = false)
    private Integer pkmId; // FK

    @Column(nullable = false)
    private Integer menuId; // FK

    @Column(nullable = false)
    private Integer dayCount;

    @Column(nullable = false)
    private Integer orderQuantity;

    @Column(nullable = false)
    private Integer orderPrice;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // Enum: progress, failure, success

    // OrderStatus Enum 내부 클래스
    public enum OrderStatus {
        PROGRESS, // 진행 중
        FAILURE,  // 실패
        SUCCESS   // 성공
    }
}
