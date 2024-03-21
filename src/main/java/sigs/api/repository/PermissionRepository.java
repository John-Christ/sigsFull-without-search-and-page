package sigs.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.model.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
}