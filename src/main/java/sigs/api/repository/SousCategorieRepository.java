package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.SousCategorie;

@Repository
public interface SousCategorieRepository extends CrudRepository<SousCategorie, Long> {
}
