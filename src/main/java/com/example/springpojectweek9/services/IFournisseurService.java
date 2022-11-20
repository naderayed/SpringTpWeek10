package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Fournisseur;

import java.util.List;

public interface IFournisseurService {

    List<Fournisseur> retrieveAllFournisseurs();
    Fournisseur addFournisseur (Fournisseur f);
    Fournisseur updateFournisseur (Fournisseur f);
    Fournisseur retrieveFournisseur (Long id);

    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long
            secteurActiviteId) ;
}
