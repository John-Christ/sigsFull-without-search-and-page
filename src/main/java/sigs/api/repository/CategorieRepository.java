package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
}
