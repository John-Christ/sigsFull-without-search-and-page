package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Demande;

@Repository
public interface DemandeRepository extends CrudRepository<Demande, Long> {
}