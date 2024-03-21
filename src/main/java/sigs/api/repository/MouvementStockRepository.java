package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.MouvementStock;

@Repository
public interface MouvementStockRepository extends CrudRepository<MouvementStock, Long> {
}
