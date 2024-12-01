package com.PokeTruck.Backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MenuIngre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MenuIngre.class)
public class MenuIngre {

    @Id
    private Integer ingreId; // PK, FK

    @Id
    private Integer menuId; // PK, FK

    @Column(nullable = false)
    private Integer ingreQuantity;
}
