package com.eddie.produit.modele;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="produit")
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    @NotNull(message = "Le nom est requis")
    private String nom;

    @Column(name = "description")
    @Size(min = 20, message = "La description doit contenir au moins 20 caractères")
    private String description;

    @Column(name = "prix")
    @PositiveOrZero(message = "Le prix doit être positif ou nul")
    private Double prix;
}
