package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
