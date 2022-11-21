package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Facture;
import com.example.springpojectweek9.Entities.Fournisseur;
import com.example.springpojectweek9.respositories.FactureRepo;
import com.example.springpojectweek9.respositories.FournisseurRepo;
import com.example.springpojectweek9.respositories.OperateurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService implements IFactureService{

    private final FactureRepo factureRepo;
    private final FournisseurRepo fournisseurRepo;



    public FactureService(FactureRepo factureRepo, OperateurRepo operateurRepo, FournisseurRepo fournisseurRepo) {
        this.factureRepo = factureRepo;

        this.fournisseurRepo = fournisseurRepo;
    }

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepo.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture = factureRepo.findById(id).orElse(null);
        if(!facture.isArchivee()){
            facture.setArchivee(true);
            factureRepo.save(facture);
        }

    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        Fournisseur fournisseur = fournisseurRepo.findById(idFournisseur).orElse(null);
        if (fournisseur !=null){
        return factureRepo.findFacturesByFournisseur(fournisseur);}
        return null;
    }


}
