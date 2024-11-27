package com.eddie.produit.contrat;

import org.springframework.http.ResponseEntity;

public interface Commande <I,O>{
    ResponseEntity<O> executer(I input);

}
