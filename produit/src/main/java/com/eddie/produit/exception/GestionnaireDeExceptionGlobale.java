package com.eddie.produit.exception;

import com.eddie.produit.modele.ReponseErreur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GestionnaireDeExceptionGlobale {
    @ExceptionHandler(ProduitIntrouveException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ReponseErreur gestionnaireProduitIntrouveException(ProduitIntrouveException exception){
        return new ReponseErreur(exception.getMessage());
    }
}
