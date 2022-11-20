package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Fournisseur;
import com.example.springpojectweek9.Entities.SecteurActivie;
import com.example.springpojectweek9.respositories.FournisseurRepo;
import com.example.springpojectweek9.respositories.SecteurActivieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService implements IFournisseurService{
  private final FournisseurRepo fournisseurRepo;
  private final SecteurActivieRepo secteurActivieRepo;

    public FournisseurService(FournisseurRepo fournisseurRepo, SecteurActivieRepo secteurActivieRepo) {
        this.fournisseurRepo = fournisseurRepo;
        this.secteurActivieRepo = secteurActivieRepo;
    }


    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepo.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return fournisseurRepo.save(f);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        Optional<Fournisseur> byId = fournisseurRepo.findById(f.getIdFournisseur());
        if (byId.isPresent()){
        return fournisseurRepo.save(f);}
        return null;

    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return fournisseurRepo.findById(id).orElse(null);
    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
        Fournisseur fournisseur = fournisseurRepo.findById(fournisseurId).orElse(null);
        SecteurActivie secteurActivie = secteurActivieRepo.findById(secteurActiviteId).orElse(null);
        fournisseur.getSecteurActivies().add(secteurActivie);
        fournisseurRepo.save(fournisseur);

    }
}
