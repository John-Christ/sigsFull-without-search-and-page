package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Pret;

@Repository
public interface PretRepository extends CrudRepository<Pret, Long> {
}
