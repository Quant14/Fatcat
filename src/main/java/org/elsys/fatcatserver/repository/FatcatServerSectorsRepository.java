package org.elsys.fatcatserver.repository;

import org.elsys.fatcatserver.module.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatcatServerSectorsRepository extends JpaRepository<Sectors, Long> {

}
