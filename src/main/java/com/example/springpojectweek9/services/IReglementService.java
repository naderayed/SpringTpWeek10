package com.example.springpojectweek9.services;

import com.example.springpojectweek9.Entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglementService {
     List<Reglement> retrieveReglementByFacture(Long idFacture);

     Reglement addReglement(Reglement r, Long idFacture);

      float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

     float pourcentageRecouvrement(Date startDate, Date endDate);

}
