package com.KilianElRincon.webAED.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//etiquetas Lombook
@Data
@NoArgsConstructor
@AllArgsConstructor
//etiquetas Hibernate
@Builder
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String logoUrl;
}
