package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.Facture;
import com.example.springpojectweek9.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepo extends JpaRepository<Facture,Long> {

    List<Facture> findFacturesByFournisseur(Fournisseur fournisseur);
}
