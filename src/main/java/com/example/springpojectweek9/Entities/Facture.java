package com.example.springpojectweek9.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;

    private boolean archivee;

    @OneToMany(mappedBy = "facture")
    List<Reglement> reglements;
    @OneToMany(mappedBy = "factureD")
    List<DetailFacture> detailFactures;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fournisseur fournisseur;




}
