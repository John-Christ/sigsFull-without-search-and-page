package sigs.api.web;


import java.util.List;

import sigs.api.model.Entrepot;
import sigs.api.repository.EntrepotRepository;
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
@RequestMapping("/entrepot")
@RestController
public class EntrepotController
{


    private final EntrepotRepository repository;

    EntrepotController(EntrepotRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Entrepot> all() {
        return (List<Entrepot>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Entrepot newEntrepot(@Valid @RequestBody Entrepot newEntrepot) {
        return repository.save(newEntrepot);
    }

    // Single item

    @GetMapping("/{id}")
    Entrepot one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Entrepot replaceEntrepot(@Valid @RequestBody Entrepot newEntrepot, @PathVariable Long id) {

        return repository.findById(id)
                .map(entrepot -> {
                    entrepot.setNom(newEntrepot.getNom());
                    entrepot.setDescription(newEntrepot.getDescription());
                    entrepot.setAdresse(newEntrepot.getAdresse());
                    entrepot.setStock(newEntrepot.getStock());

                    return repository.save(entrepot);
                })
                .orElseGet(() -> {
                    newEntrepot.setId(id);
                    return repository.save(newEntrepot);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEntrepot(@PathVariable Long id) {
        repository.deleteById(id);
    }






}


