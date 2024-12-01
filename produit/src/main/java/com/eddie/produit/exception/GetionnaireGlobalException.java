package com.eddie.produit.exception;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GetionnaireGlobalException {

    @ExceptionHandler(ProduitIntrouveException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErreurMessage retournerErreur(ProduitIntrouveException produitIntrouveException){
        return new ErreurMessage(produitIntrouveException.getMessage());

    }


    @ExceptionHandler(ProduitInvalideException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErreurMessage produitInvalideException(ProduitInvalideException produitInvalideException){
        return new ErreurMessage(produitInvalideException.getMessage());
    }

@ExceptionHandler(ConstraintViolationException.class)
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErreurMessage gestionnaireInvalideConstrainte(ConstraintViolationException constraintViolationException){
        return new ErreurMessage(constraintViolationException.getConstraintViolations().iterator().next().getMessage());
    }

}
