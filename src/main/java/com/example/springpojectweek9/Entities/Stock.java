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
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    private Integer qte;
    private Integer qteMin;
    private String libelleStock;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stock")
    List<Produit> produitList;
}
