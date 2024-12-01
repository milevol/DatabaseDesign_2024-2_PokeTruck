package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`Rank`")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rankId;

    @Column(nullable = false)
    private Integer userId; // FK

    @Column(nullable = false)
    private Integer ranking;

    @Column(nullable = false)
    private Integer totalSales;  // 매출 정보 필드 추가
}
