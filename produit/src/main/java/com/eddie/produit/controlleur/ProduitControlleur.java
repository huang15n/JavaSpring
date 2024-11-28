package com.eddie.produit.controlleur;


import com.eddie.produit.DTO.ProduitDTO;
import com.eddie.produit.exception.ProduitIntrouveException;
import com.eddie.produit.modele.Produit;
import com.eddie.produit.modele.ProduitAjouterCommande;
import com.eddie.produit.modele.ReponseErreur;
import com.eddie.produit.service.*;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitControlleur {


    private final ChercherService chercherService;
    private final ModifierService modifierService;
    private final SupprimerService supprimerService;
    private final AjouterService ajouterService;
    private final ChercherUnArticleService chercherUnArticleService;


    public ProduitControlleur(ChercherService chercherService, ModifierService modifierService, SupprimerService supprimerService, AjouterService ajouterService, ChercherUnArticleService chercherUnArticleService) {
        this.chercherService = chercherService;
        this.modifierService = modifierService;
        this.supprimerService = supprimerService;
        this.ajouterService = ajouterService;
        this.chercherUnArticleService = chercherUnArticleService;
    }

    @GetMapping("/produits")
    public ResponseEntity<List<ProduitDTO>> rechercher(){
        return this.chercherService.executer();
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<ProduitDTO> rechercherUnArticle(@PathVariable Integer id){
        return this.chercherUnArticleService.executer(id);

    }
    @PostMapping("/produit")
    public ResponseEntity<ProduitDTO> ajouter(@RequestBody Produit produit){
        return this.ajouterService.executer(produit);
    }

    @PutMapping("/produit/{id}")
    public ResponseEntity<ProduitDTO> modifier(@PathVariable Integer id, @RequestBody Produit produit){
        return this.modifierService.executer(new ProduitAjouterCommande(id, produit));
    }

    @DeleteMapping("/produit/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Integer id){
        return this.supprimerService.executer(id);
    }

//    @ExceptionHandler(ProduitIntrouveException.class)
//    public ResponseEntity<ReponseErreur> gestionnaireProduitIntrouveException(ProduitIntrouveException exception){
//        // Création de la réponse d'erreur avec le message de l'exception
//        ReponseErreur errorResponse = new ReponseErreur(exception.getMessage());
//
//        // Retourne la réponse avec un statut 404 Not Found
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }



}
