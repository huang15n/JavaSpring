package com.eddie.produit.exception;

public enum MessageErreur {
    PRODUIT_INTROUVE("Produit Introuve Malheuresement");

    private final String message;

    MessageErreur(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
