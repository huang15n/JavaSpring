package com.eddie.produit.modele;

import lombok.Getter;

@Getter
public class ReponseErreur {
    private String message;

    public ReponseErreur(String message) {
        this.message = message;
    }
}
