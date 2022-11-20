package com.example.springpojectweek9.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long  idRegelemnt;
  private float  montantPaye;
   private float montantRestant;
   private boolean payee;
    @Temporal(TemporalType.DATE)
   private Date dateReglement;

    @ManyToOne(cascade = CascadeType.ALL)
    private Facture facture;

}
