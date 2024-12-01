package com.eddie.produit.exception;

public enum MessageErreur {
    PRODUIT_INTROUVE("Produit introuvable, malheureusement."),
    NOM_INTROUVE("Le nom est obligatoire."),
    DESCRIPTION_LONGUEUR("La description doit contenir au moins 20 caractères."),
    PRIX_NEGATIF("Le prix ne doit pas être négatif.");

    private final String message;

    MessageErreur(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
