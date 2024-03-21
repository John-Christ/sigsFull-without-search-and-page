package sigs.api.web;


import java.util.List;

import sigs.api.model.Demande;
import sigs.api.repository.DemandeRepository;
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
@RequestMapping("/demande")
@RestController
public class DemandeController
{


    private final DemandeRepository repository;

    DemandeController(DemandeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping
    List<Demande> all() {
        return (List<Demande>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping
    Demande newDemande(@Valid @RequestBody Demande newDemande) {
        return repository.save(newDemande);
    }

    // Single item

    @GetMapping("/{id}")
    Demande one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/{id}")
    Demande replaceDemande(@RequestBody Demande newDemande, @PathVariable Long id) {

        return repository.findById(id)
                .map(demande -> {
                    demande.setNom(newDemande.getNom());
                    demande.setPrenom(newDemande.getPrenom());
                    demande.setEmail(newDemande.getEmail());
                    demande.setTel(newDemande.getTel());
                    demande.setDate(newDemande.getDate());
                    demande.setStatut(newDemande.getStatut());
                    demande.setAssignedProduits(newDemande.getAssignedProduits());
                    demande.setUtilisateur(newDemande.getUtilisateur());

                    return repository.save(demande);
                })
                .orElseGet(() -> {
                    newDemande.setId(id);
                    return repository.save(newDemande);
                });
    }

    @DeleteMapping("/{id}")
    void deleteDemande(@PathVariable Long id) {
        repository.deleteById(id);
    }









}


