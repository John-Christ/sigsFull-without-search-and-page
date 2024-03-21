package sigs.api.web;


import java.util.List;

import sigs.api.model.Fournisseur;
import sigs.api.repository.FournisseurRepository;
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
@RequestMapping("/fournisseur")
@RestController
public class FournisseurController
{


    private final FournisseurRepository repository;

    FournisseurController(FournisseurRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Fournisseur> all() {
        return (List<Fournisseur>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Fournisseur newFournisseur(@Valid @RequestBody Fournisseur newFournisseur) {
        return repository.save(newFournisseur);
    }

    // Single item

    @GetMapping("/{id}")
    Fournisseur one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Fournisseur replaceFournisseur(@Valid @RequestBody Fournisseur newFournisseur, @PathVariable Long id) {

        return repository.findById(id)
                .map(fournisseur -> {
                    fournisseur.setNom(newFournisseur.getNom());
                    fournisseur.setEmail(newFournisseur.getEmail());
                    fournisseur.setAdresse(newFournisseur.getAdresse());
                    fournisseur.setVille(newFournisseur.getVille());
                    fournisseur.setTel(newFournisseur.getTel());
                    fournisseur.setPays(newFournisseur.getPays());
                    fournisseur.setCompteFournisseur(newFournisseur.getCompteFournisseur());

                    return repository.save(fournisseur);
                })
                .orElseGet(() -> {
                    newFournisseur.setId(id);
                    return repository.save(newFournisseur);
                });
    }

    @DeleteMapping("/{id}")
    void deleteFournisseur(@PathVariable Long id) {
        repository.deleteById(id);
    }






}
