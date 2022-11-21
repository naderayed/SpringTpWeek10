package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Produit;
import com.example.springpojectweek9.Entities.Stock;
import com.example.springpojectweek9.respositories.ProduitRepo;
import com.example.springpojectweek9.respositories.StockRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockService implements  IStockService{
    private final StockRepo stockRepo;
    private final ProduitRepo produitRepo;

    public StockService(StockRepo stockRepo, ProduitRepo produitRepo) {
        this.stockRepo = stockRepo;
        this.produitRepo = produitRepo;
    }

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepo.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepo.save(s);
    }

    @Override
    public Stock updateStock(Stock s) {
        return stockRepo.save(s);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepo.findById(id).orElse(null);
    }

    @Override
    public void removeStock(Long id) {
        if (stockRepo.findById(id).isPresent())
        stockRepo.deleteById(id);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepo.findById(idProduit).orElse(null);
        Stock stock = stockRepo.findById(idStock).orElse(null);
        stock.getProduitList().add(produit);
        stockRepo.save(stock);
    }

    @Scheduled(cron = "*/5 * * * * * ")
    public void retrivesStatusStock(){
        List<Stock> all = stockRepo.findAll();
        log.info(all.toString());

    }
}
