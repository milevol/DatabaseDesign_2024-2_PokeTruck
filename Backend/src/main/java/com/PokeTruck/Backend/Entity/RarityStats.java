package com.poketruck.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "RarityStats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RarityStats {

    @Id
    private Integer rarity; // 0: normal, 1: legend, 2: myth

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal rate;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal bonus;
}
