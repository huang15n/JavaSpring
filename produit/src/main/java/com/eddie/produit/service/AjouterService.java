package com.eddie.produit.service;


import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.contrat.Commande;
import com.eddie.produit.exception.ErreurMessage;
import com.eddie.produit.exception.MessageErreur;
import com.eddie.produit.exception.ProduitInvalideException;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.referentielle.ProduitReferentielle;
import com.eddie.produit.validateur.ProduitValidateur;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AjouterService implements Commande<Produit, ProduitDTO> {

    private ProduitReferentielle produitReferentielle;

    public AjouterService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }

    @Override
    public ResponseEntity<ProduitDTO> executer(Produit produit){
        // ProduitValidateur.executer(produit);


        Produit produitAjoute = produitReferentielle.save(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProduitDTO(produitAjoute));
    }




}
