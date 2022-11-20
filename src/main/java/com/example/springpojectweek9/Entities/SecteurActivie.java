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
public class SecteurActivie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSecteurActivie;
    private String CodeSecteurActivie;
    private String libelleSecteurActivie;

    @ManyToMany(mappedBy ="secteurActivies")
    List<Fournisseur> fournisseurList;
}
