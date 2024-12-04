package com.eddie.produit.service;

import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.contrat.Chercher;
import com.eddie.produit.contrat.Commande;
import com.eddie.produit.referentielle.ProduitReferentielle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ChercherProduitService implements Commande<String, List<ProduitDTO>> {
private final ProduitReferentielle produitReferentielle;

    public ChercherProduitService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }


    @Override
    public ResponseEntity<List<ProduitDTO>> executer(String parametre) {
        return ResponseEntity.ok(produitReferentielle.rechercherParDescription(parametre).stream().map(ProduitDTO::new).toList());
    }

    /**
     * '  @Override
     *     public ResponseEntity<List<ProduitDTO>> executer(String parametre) {
     *         return ResponseEntity.ok(produitReferentielle.findByNomContaining(parametre).stream().map(ProduitDTO::new).toList());
     *     }
     */
}
