package com.example.springpojectweek9.Entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class DetailFacture {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long idDetailFacture;
   private Integer qteCommandee;
   private float prixTotalDetail;
   private Integer pourcentageRemise;
   private float montantRemise;
   @ManyToOne(cascade = CascadeType.ALL)
   private Facture factureD;

   @ManyToOne(cascade = CascadeType.ALL)
   private Produit produit;




}
