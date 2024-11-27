package com.eddie.produit.modele;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="produit")
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Double prix;


}
