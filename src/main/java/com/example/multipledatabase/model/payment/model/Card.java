package com.example.multipledatabase.model.payment.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CARD")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String ExprirationMoth;
}
