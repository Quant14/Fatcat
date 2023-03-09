package org.elsys.fatcatserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatcatServerRepository extends JpaRepository<Person, Integer> {

}
