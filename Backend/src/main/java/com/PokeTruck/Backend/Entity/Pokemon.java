package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkmId;

    @Column(nullable = false)
    private Integer rarity; // FK (0: normal, 1: legend, 2: myth)

    @Column(nullable = false, length = 20)
    private String pkmName;

    @Column(nullable = false, length = 10)
    private String pkmType;
}
