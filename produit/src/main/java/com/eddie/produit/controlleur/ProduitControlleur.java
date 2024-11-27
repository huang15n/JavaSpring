package com.eddie.produit.controlleur;


import com.eddie.produit.modele.Produit;
import com.eddie.produit.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduitControlleur {


    private final ChercherService chercherService;
    private final ModifierService modifierService;
    private final SupprimerService supprimerService;
    private final AjouterService ajouterService;


    @Autowired
    public ProduitControlleur(ChercherService chercherService, ModifierService modifierService, SupprimerService supprimerService, AjouterService ajouterService) {
        this.chercherService = chercherService;
        this.modifierService = modifierService;
        this.supprimerService = supprimerService;
        this.ajouterService = ajouterService;
    }





    @RequestMapping("rechercher")
    public ResponseEntity<List<Produit>> rechercher(){
        return this.chercherService.executer();
    }

    @RequestMapping("ajouter")
    public ResponseEntity<String> ajouter(){
        return this.ajouterService.executer(null);
    }

    @RequestMapping("modifier")
    public ResponseEntity<String> modifier(){
        return this.modifierService.executer(null);
    }

    @RequestMapping("supprimer")
    public ResponseEntity<String> supprimer(){
        return this.supprimerService.executer(null);
    }



}
