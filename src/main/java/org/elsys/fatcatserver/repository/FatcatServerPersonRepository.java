package org.elsys.fatcatserver.repository;

import org.elsys.fatcatserver.module.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatcatServerPersonRepository extends JpaRepository<Person, Long> {

}
