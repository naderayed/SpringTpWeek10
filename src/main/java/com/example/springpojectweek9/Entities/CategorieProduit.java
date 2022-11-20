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
public class CategorieProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorieProduit;
    private String codePoduit;
    private String libelleCategorieProduit;
    @OneToMany(mappedBy = "categorieProduit")
    private List<Produit> produitList;
}
