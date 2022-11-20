package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Produit;

import java.util.List;

public interface IPoduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit updateProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit retrieveProduit(Long id);


}
