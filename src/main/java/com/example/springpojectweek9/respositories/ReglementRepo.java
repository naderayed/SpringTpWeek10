package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.Facture;
import com.example.springpojectweek9.Entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReglementRepo extends JpaRepository<Reglement,Long> {

    List<Reglement> findReglementsByFacture(Facture facture);
    List<Reglement> findReglementsByDateReglementAfterAndDateReglementBefore(Date after , Date before);
}
