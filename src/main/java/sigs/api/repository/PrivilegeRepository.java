package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
}