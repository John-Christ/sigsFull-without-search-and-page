package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.CompteFournisseur;

@Repository
public interface CompteFournisseurRepository extends CrudRepository<CompteFournisseur, Long> {
}
