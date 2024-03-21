package sigs.api.web;

import java.util.List;

import sigs.api.model.Produit;
import sigs.api.repository.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;


//@CrossOrigin("http://localhost:4200")
@Controller
@RequestMapping("/produit")
@RestController
public class ProduitController
{


    private final ProduitRepository repository;

    ProduitController(ProduitRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Produit> all() {
        return (List<Produit>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Produit newProduit(@Valid @RequestBody Produit newProduit) {
        return repository.save(newProduit);
    }

    // Single item

    @GetMapping("/{id}")
    Produit one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Produit replaceProduit(@Valid @RequestBody Produit newProduit, @PathVariable Long id) {

        return repository.findById(id)
                .map(produit -> {
                    produit.setNom(newProduit.getNom());
                    produit.setDescription(newProduit.getDescription());
                    produit.setDate_creation(newProduit.getDate_creation());
                    produit.setSeuil(newProduit.getSeuil());
                    produit.setQte(newProduit.getQte());

                    produit.setCategorie(newProduit.getCategorie());
                    produit.setSousCategorie(newProduit.getSousCategorie());
                    produit.setCommandeSet(newProduit.getCommandeSet());
                    produit.setDemandeSet(newProduit.getDemandeSet());
                    produit.setPretSet(newProduit.getPretSet());
                    produit.setStockSet(newProduit.getStockSet());

                    return repository.save(produit);
                })
                .orElseGet(() -> {
                    newProduit.setId(id);
                    return repository.save(newProduit);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProduit(@PathVariable Long id) {
        repository.deleteById(id);
    }






}

