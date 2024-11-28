package com.eddie.produit.service;

import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.contrat.Commande;
import com.eddie.produit.exception.ProduitIntrouveException;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.referentielle.ProduitReferentielle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChercherUnArticleService implements Commande<Integer, ProduitDTO> {
    private final ProduitReferentielle produitReferentielle;

    public ChercherUnArticleService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }


    @Override
    public ResponseEntity<ProduitDTO> executer(Integer id) {
        Optional<Produit> produitOptionel = this.produitReferentielle.findById(Long.valueOf(id));
        if(produitOptionel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ProduitDTO(produitOptionel.get()));
        }

        throw new ProduitIntrouveException();
    }
}
