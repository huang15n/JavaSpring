package com.eddie.produit.DTO;

import com.eddie.produit.modele.Produit;
import lombok.Data;

@Data
public class ProduitDTO {

    private Integer id;
    private String nom;
    private String description;

    public ProduitDTO(Produit produit) {
        this.id = produit.getId();
        this.nom = produit.getNom();
        this.description = produit.getDescription();
    }
}
