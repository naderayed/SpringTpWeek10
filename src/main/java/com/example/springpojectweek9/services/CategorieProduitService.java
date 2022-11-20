package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.CategorieProduit;
import com.example.springpojectweek9.respositories.CategorieProduitRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategorieProduitService implements  ICategorieProduitService{

    private final CategorieProduitRepo categorieProduitRepo;

    public CategorieProduitService(CategorieProduitRepo categorieProduitRepo) {
        this.categorieProduitRepo = categorieProduitRepo;
    }

    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        return  categorieProduitRepo.findAll();
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit cp) {
        return categorieProduitRepo.save(cp);
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
            return categorieProduitRepo.save(cp);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {
        return categorieProduitRepo
                .findById(id).
                orElseThrow(() -> new IllegalStateException("no such Categorie with id " +id));
    }

    @Override
    public void removeCategorieProduit(Long id) {
        Optional<CategorieProduit> byId = categorieProduitRepo.findById(id);

        if(byId.isPresent()){
            categorieProduitRepo.deleteById(id);
        }
    }
}
