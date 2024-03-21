package sigs.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}