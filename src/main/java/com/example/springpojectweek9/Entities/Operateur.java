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
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperateur;
    private String nom;
    private String prenom;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Facture>  facture;

}
