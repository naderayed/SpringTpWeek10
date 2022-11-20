package com.example.springpojectweek9.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    private String codeFournisseur;
    private String libelleFournisseur;
    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categorieFournisseur;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fournisseur")
    List<Facture> factures;

    @ManyToMany(cascade = CascadeType.ALL)
    List<SecteurActivie>secteurActivies;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailFournisseur detailFournisseur ;
}
