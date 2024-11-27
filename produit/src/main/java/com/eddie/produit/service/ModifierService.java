package com.eddie.produit.service;


import com.eddie.produit.contrat.Commande;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ModifierService implements Commande<Void, String> {


    @Override
    public ResponseEntity<String> executer(Void input) {
       return ResponseEntity.status(HttpStatus.OK).body("modifier");
    }


}