package sigs.api.web;


import java.util.List;

import sigs.api.model.Pret;
import sigs.api.repository.PretRepository;
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
@RequestMapping("/pret")
@RestController
public class PretController
{


    private final PretRepository repository;

    PretController(PretRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Pret> all() {
        return (List<Pret>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Pret newPret(@Valid @RequestBody Pret newPret) {
        return repository.save(newPret);
    }

    // Single item

    @GetMapping("{id}")
    Pret one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Pret replacePret(@Valid @RequestBody Pret newPret, @PathVariable Long id) {

        return repository.findById(id)
                .map(pret -> {
                    pret.setNom(newPret.getNom());
                    pret.setDate_sortie(newPret.getDate_sortie());
                    pret.setDate_retour(newPret.getDate_retour());
                    pret.setDescription(newPret.getDescription());
                    pret.setDirection(newPret.getDirection());
                    pret.setStatut(newPret.getStatut());
                    pret.setQte(newPret.getQte());
                    pret.setAssignedProduits(newPret.getAssignedProduits());
                    return repository.save(pret);
                })
                .orElseGet(() -> {
                    newPret.setId(id);
                    return repository.save(newPret);
                });
    }

    @DeleteMapping("/{id}")
    void deletePret(@PathVariable Long id) {
        repository.deleteById(id);
    }











}


