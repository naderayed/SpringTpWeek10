package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Long> {
}
