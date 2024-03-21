package sigs.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sigs.api.dao.DAOUser;

@Repository
public interface DaoUser extends CrudRepository<DAOUser, Long> {
}
