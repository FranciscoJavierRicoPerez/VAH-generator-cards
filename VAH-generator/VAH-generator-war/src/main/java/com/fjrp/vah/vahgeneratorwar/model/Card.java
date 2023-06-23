package com.fjrp.vah.vahgeneratorwar.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "CARDS")
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CARDTYPE")
    private String cardType; // Blanca o Negra

    @Column(name = "CARDBODY")
    private String cardBody; // Texto de la carta
}
