package com.eddie.produit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProduitInvalideException extends RuntimeException{

    public  ProduitInvalideException(String message){
        super(message);
    }

}
