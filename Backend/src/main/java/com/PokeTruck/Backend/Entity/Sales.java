package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesId;

    @Column(nullable = false)
    private Integer userId; // FK

    @Column(nullable = false)
    private Integer dayCount;

    @Column(nullable = false)
    private Integer daySales;
}
