package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieProduitRepo extends JpaRepository<CategorieProduit,Long> {
}
