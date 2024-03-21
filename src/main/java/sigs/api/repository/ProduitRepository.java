package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
}
