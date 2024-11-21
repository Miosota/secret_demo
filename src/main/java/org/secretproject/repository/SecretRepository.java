package org.secretproject.repository;

import org.secretproject.model.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long>{
    //some methods to work with data base

}
