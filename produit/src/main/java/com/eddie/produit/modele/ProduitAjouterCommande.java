package com.eddie.produit.modele;

import lombok.Getter;

@Getter
public class ProduitAjouterCommande {
    private Integer id;
    private Produit produit;

    public ProduitAjouterCommande(Integer id, Produit produit) {
        this.id = id;
        this.produit = produit;
    }
}
