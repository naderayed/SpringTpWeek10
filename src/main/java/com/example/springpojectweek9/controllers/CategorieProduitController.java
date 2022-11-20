package com.example.springpojectweek9.controllers;

import com.example.springpojectweek9.Entities.CategorieProduit;
import com.example.springpojectweek9.services.ICategorieProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CategorieProduit/")
public class CategorieProduitController {
    private final ICategorieProduitService iCategorieProduitService;

    public CategorieProduitController(ICategorieProduitService iCategorieProduitService) {
        this.iCategorieProduitService = iCategorieProduitService;
    }
    @GetMapping(path = "all")
    public List<CategorieProduit> retrieveAllCategorieProduits(){
      return   iCategorieProduitService.retrieveAllCategorieProduits();
    }

    @PostMapping(path = "add")
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit cp){
        return iCategorieProduitService.addCategorieProduit(cp);
    }

    @PutMapping(path = "update")
    public CategorieProduit updateCategorieProduit(@RequestBody CategorieProduit cp) {

        return iCategorieProduitService.updateCategorieProduit(cp);
    }
    @GetMapping(path = "get/{id}")
    public CategorieProduit retrieveCategorieProduit(@PathVariable("id") Long id){

        return iCategorieProduitService.retrieveCategorieProduit(id);
    }
    @DeleteMapping(path = "delete/{id}")
    public void removeCategorieProduit(Long id){
         iCategorieProduitService.removeCategorieProduit(id);
    }

}
