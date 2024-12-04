package com.eddie.produit.referentielle;

import com.eddie.produit.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitReferentielle  extends JpaRepository<Produit, Long> {
    List<Produit> findByNomContaining(String nom);

    @Query("SELECT p FROM Produit p WHERE p.description LIKE %:motCle%")
    List<Produit> rechercherParDescription(@Param("motCle") String motCle);
}
