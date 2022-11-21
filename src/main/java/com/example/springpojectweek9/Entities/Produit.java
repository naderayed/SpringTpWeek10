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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="produit")
    List<DetailFacture> detailFactureList;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL)
    private  CategorieProduit categorieProduit;

}
