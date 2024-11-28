package com.eddie.produit.service;


import com.eddie.produit.contrat.Commande;
import com.eddie.produit.exception.ProduitIntrouveException;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.referentielle.ProduitReferentielle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupprimerService implements Commande<Integer, Void> {

    private final ProduitReferentielle produitReferentielle;

    public SupprimerService(ProduitReferentielle produitReferentielle) {
        this.produitReferentielle = produitReferentielle;
    }

    @Override
    public ResponseEntity<Void> executer(Integer id){
        Optional<Produit> produitOptionel = produitReferentielle.findById(Long.valueOf(id));
        if(produitOptionel.isPresent()){
            produitReferentielle.deleteById(Long.valueOf(id));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        // Au lieu de retourner 'null', nous lançons une exception d'exécution avec un message spécifique
        // Cela permet de fournir un message d'erreur personnalisé
        throw new ProduitIntrouveException();

        // Si nous envoyons une réponse API avec un objet introuvable, Spring Boot renverra le message par défaut
        // Si nous voulons que le message que nous avons passé dans l'exception soit inclus dans la réponse,
        // nous devons configurer la propriété dans le fichier 'application.properties' :
        // server.error.include-message=always



    }
}
