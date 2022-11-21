package com.example.springpojectweek9.controllers;


import com.example.springpojectweek9.Entities.Produit;
import com.example.springpojectweek9.services.ICategorieProduitService;
import com.example.springpojectweek9.services.IPoduitService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Produit/")
public class ProduitController {
    private final IPoduitService iPoduitService;

    public ProduitController(ICategorieProduitService iCategorieProduitService, IPoduitService iPoduitService) {

        this.iPoduitService = iPoduitService;
    }

    @PostMapping(path = "add/{idC}/{ids}")
    public Produit addProduit(@RequestBody Produit p, @PathVariable("idC") Long idCategorieProduit, @PathVariable("ids") Long idStock){

        return iPoduitService.addProduit(p,idCategorieProduit,idStock);
    }
}
