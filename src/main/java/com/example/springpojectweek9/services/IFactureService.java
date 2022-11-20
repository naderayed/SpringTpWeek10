package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);

    List<Facture> getFacturesByFournisseur(Long idFournisseur);

}
