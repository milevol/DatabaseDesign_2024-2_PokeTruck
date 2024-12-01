package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ingre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingreId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String ingreName;

    @Column(nullable = false)
    private String ingreType;

    @Column(nullable = false)
    private Integer ingreCost;

    @Column(nullable = false)
    private Integer isUnlocked = 0; // 0: 잠금, 1: 해제
}
