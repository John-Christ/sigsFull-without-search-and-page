package sigs.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Entrepot;

@Repository
public interface EntrepotRepository extends CrudRepository<Entrepot, Long> {
}