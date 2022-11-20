package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Facture;
import com.example.springpojectweek9.Entities.Operateur;
import com.example.springpojectweek9.respositories.FactureRepo;
import com.example.springpojectweek9.respositories.OperateurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateurService implements IOperateurService{

    private final OperateurRepo operateurRepo;
    private final FactureRepo factureRepo;


    public OperateurService(OperateurRepo operateurRepo, FactureRepo factureRepo) {
        this.operateurRepo = operateurRepo;
        this.factureRepo = factureRepo;
    }

    @Override
    public List<Operateur> retrieveAllOperateurs() {
        return operateurRepo.findAll();
    }

    @Override
    public Operateur addOperateur(Operateur o) {
        return operateurRepo.save(o);
    }

    @Override
    public Operateur updateOperateur(Operateur o) {
        return operateurRepo.save(o);
    }

    @Override
    public Operateur retrieveOperateur(Long id) {
        return operateurRepo.findById(id).orElse(null);
    }

    @Override
    public void removeOperateur(Long id) {
        operateurRepo.deleteById(id);

    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        Operateur operateur = operateurRepo.findById(idOperateur).orElse(null);
        Facture facture = factureRepo.findById(idFacture).orElse(null);

        operateur.getFacture().add(facture);
        operateurRepo.save(operateur);
    }
}
