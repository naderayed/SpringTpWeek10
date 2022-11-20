package com.example.springpojectweek9.respositories;

import com.example.springpojectweek9.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur,Long> {
}
