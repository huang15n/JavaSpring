package com.eddie.produit.exception;


import lombok.Getter;

@Getter
public class ErreurMessage {
    private final String message;

    public ErreurMessage(String message) {
        this.message = message;
    }
}
