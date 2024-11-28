package com.eddie.produit.service;


import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.contrat.Commande;
import com.eddie.produit.exception.ProduitIntrouveException;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.modele.ProduitAjouterCommande;
import com.eddie.produit.referentielle.ProduitReferentielle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModifierService implements Commande<ProduitAjouterCommande, ProduitDTO> {

    private final ProduitReferentielle produitReferentielle;

    public ModifierService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }

    @Override
    public ResponseEntity<ProduitDTO> executer(ProduitAjouterCommande produitAjouterCommande) {
        Optional<Produit> produitOptionel = Optional.of(produitReferentielle.getReferenceById(Long.valueOf(produitAjouterCommande.getId())));

        if(produitOptionel.isPresent()){
            Produit produit = produitAjouterCommande.getProduit();
            produit.setId(produitAjouterCommande.getId());
            produitReferentielle.save(produit);
            return ResponseEntity.ok(new ProduitDTO(produit));
        }
       throw new ProduitIntrouveException();
    }


}
