package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock s);

    Stock retrieveStock(Long id);

    void removeStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);
}
