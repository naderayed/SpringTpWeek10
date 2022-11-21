package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.CategorieProduit;
import com.example.springpojectweek9.Entities.Produit;
import com.example.springpojectweek9.respositories.CategorieProduitRepo;
import com.example.springpojectweek9.respositories.ProduitRepo;
import com.example.springpojectweek9.respositories.StockRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements  IPoduitService{

    private final ProduitRepo produitRepo;
    private final StockRepo stockRepo;
    private final CategorieProduitRepo categorieProduitRepo;



    public ProduitService(ProduitRepo produitRepo, StockRepo stockRepo, CategorieProduitRepo categorieProduitRepo) {
        this.produitRepo = produitRepo;
        this.stockRepo = stockRepo;
        this.categorieProduitRepo = categorieProduitRepo;
    }

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        CategorieProduit categorieProduit = categorieProduitRepo.findById(idCategorieProduit).orElse(null);
        p.setCategorieProduit(categorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {

        CategorieProduit categorieProduit = categorieProduitRepo.findById(idCategorieProduit).orElse(null);
        p.setCategorieProduit(categorieProduit);
        p.setStock(stockRepo.findById(idStock).orElse(null));
        return produitRepo.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.findById(id).orElse(null);
    }


}
