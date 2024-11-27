package com.eddie.produit.referentielle;

import com.eddie.produit.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitReferentielle  extends JpaRepository<Produit, Long> {
}
