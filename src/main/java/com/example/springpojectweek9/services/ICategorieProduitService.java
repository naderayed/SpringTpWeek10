package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.CategorieProduit;

import java.util.List;

public interface ICategorieProduitService {

    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit cp);

    CategorieProduit updateCategorieProduit(CategorieProduit cp);

    CategorieProduit retrieveCategorieProduit(Long id);

    void removeCategorieProduit(Long id);

}
