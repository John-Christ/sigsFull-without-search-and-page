package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
