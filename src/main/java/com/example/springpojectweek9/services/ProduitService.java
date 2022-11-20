package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Produit;
import com.example.springpojectweek9.Entities.Stock;
import com.example.springpojectweek9.respositories.ProduitRepo;
import com.example.springpojectweek9.respositories.StockRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements  IPoduitService{

    private final ProduitRepo produitRepo;
    private final StockRepo stockRepo;


    public ProduitService(ProduitRepo produitRepo, StockRepo stockRepo) {
        this.produitRepo = produitRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        p.setIdProduit(idCategorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
        p.setIdProduit(idCategorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.findById(id).orElse(null);
    }


}
