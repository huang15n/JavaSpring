package com.eddie.produit.validateur;

import com.eddie.produit.exception.MessageErreur;
import com.eddie.produit.exception.ProduitInvalideException;
import com.eddie.produit.modele.Produit;
import io.micrometer.common.util.StringUtils;

public class ProduitValidateur {
    public ProduitValidateur() {
    }

    public static void executer(Produit produit) {
        if(StringUtils.isEmpty(produit.getNom())){
            throw new ProduitInvalideException(MessageErreur.NOM_INTROUVE.getMessage());
        }

        if(produit.getDescription().length() < 20){
            throw new ProduitInvalideException(MessageErreur.DESCRIPTION_LONGUEUR.getMessage());
        }

        if(produit.getPrix() == null || produit.getPrix() < 0.00){
            throw new ProduitInvalideException(MessageErreur.PRIX_NEGATIF.getMessage());
        }
    }


}
