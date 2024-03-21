package sigs.api.web;


import java.util.List;

import sigs.api.model.MouvementStock;
import sigs.api.repository.MouvementStockRepository;
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
@RequestMapping("/mouvement-stock")
@RestController
public class MouvementStockController
{


    private final MouvementStockRepository repository;

    MouvementStockController(MouvementStockRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<MouvementStock> all() {
        return (List<MouvementStock>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    MouvementStock newMouvementStock(@Valid @RequestBody MouvementStock newMouvementStock) {
        return repository.save(newMouvementStock);
    }

    // Single item

    @GetMapping("/{id}")
    MouvementStock one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    MouvementStock replaceMouvementStock(@Valid @RequestBody MouvementStock newMouvementStock, @PathVariable Long id) {

        return repository.findById(id)
                .map(mouvementStock -> {
                    mouvementStock.setNom(newMouvementStock.getNom());
                    mouvementStock.setType_mouvement(newMouvementStock.getType_mouvement());
                    mouvementStock.setStatut(newMouvementStock.getStatut());
                    mouvementStock.setQte(newMouvementStock.getQte());
                    return repository.save(mouvementStock);
                })
                .orElseGet(() -> {
                    newMouvementStock.setId(id);
                    return repository.save(newMouvementStock);
                });
    }

    @DeleteMapping("/{id}")
    void deleteMouvementStock(@PathVariable Long id) {
        repository.deleteById(id);
    }










}



