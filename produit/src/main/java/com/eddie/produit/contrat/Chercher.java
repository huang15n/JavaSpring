package com.eddie.produit.contrat;

import org.springframework.http.ResponseEntity;

public interface Chercher <I,O>{

    ResponseEntity<O> executer();

}
