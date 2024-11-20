package org.secretproject.repository;

import org.secretproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    //some methods to work with data base


}
