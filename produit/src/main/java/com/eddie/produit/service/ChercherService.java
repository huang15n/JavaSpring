package com.eddie.produit.service;


import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.contrat.Chercher;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.referentielle.ProduitReferentielle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChercherService implements Chercher<Void, List<ProduitDTO>> {

    private final ProduitReferentielle produitReferentielle;

    @Autowired
     public ChercherService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }



    @Override
    public ResponseEntity<List<ProduitDTO>> executer() {
        List<Produit> produits = this.produitReferentielle.findAll();
        List<ProduitDTO> produitDTOs = produits.stream().map(ProduitDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(produitDTOs);

    }
}
