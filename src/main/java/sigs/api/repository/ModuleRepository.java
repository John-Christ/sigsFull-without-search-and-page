package sigs.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {
}