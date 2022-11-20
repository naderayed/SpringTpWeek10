package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Facture;
import com.example.springpojectweek9.Entities.Reglement;
import com.example.springpojectweek9.respositories.FactureRepo;
import com.example.springpojectweek9.respositories.ReglementRepo;

import java.util.Date;
import java.util.List;

public class ReglementService implements IReglementService{
    private final ReglementRepo reglementRepo;
    private final FactureRepo factureRepo;

    public ReglementService(ReglementRepo reglementRepo, FactureRepo factureRepo) {
        this.reglementRepo = reglementRepo;
        this.factureRepo = factureRepo;
    }

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {
        Facture facture = factureRepo.findById(idFacture).orElse(null);
        if(facture != null)
            return reglementRepo.findReglementsByFacture(facture);
         return null;
    }

    @Override
    public Reglement addReglement(Reglement r, Long idFacture) {
        Facture facture = factureRepo.findById(idFacture).orElse(null);
        if (facture != null) {
            float somme = facture.getMontantFacture() - facture.getMontantRemise();
            for (Reglement re : facture.getReglements()) {
                somme = -re.getMontantPaye();
            }
            if (r.getMontantPaye() >= somme) {

             return    reglementRepo.save(r);
            }

        }

return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Reglement> reglements = reglementRepo.findReglementsByDateReglementAfterAndDateReglementBefore(startDate, endDate);
       float global=0 ;
        for (Reglement re : reglements){
           if(!re.getFacture().isArchivee()){
               global =+ re.getMontantPaye();
           }
        }
        return global;
    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
        List<Reglement> reglements = reglementRepo.findReglementsByDateReglementAfterAndDateReglementBefore(startDate, endDate);
       int c=1 ;
        for (Reglement re : reglements){
            if(!re.getFacture().isArchivee()){
               c=+1;
            }

        }
        return reglements.size()/c;

    }
}
