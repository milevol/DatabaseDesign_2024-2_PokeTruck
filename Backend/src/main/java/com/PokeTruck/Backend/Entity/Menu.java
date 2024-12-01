package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    @Column(nullable = false, length = 20)
    private String menuName;

    @Column(nullable = false)
    private Integer menuPrice;

    @Column(nullable = false)
    private Integer isUnlocked = 0;

    @Column(nullable = false)
    private Integer userId; // FK
}
