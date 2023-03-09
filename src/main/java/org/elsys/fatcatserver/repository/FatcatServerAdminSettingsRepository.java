package org.elsys.fatcatserver.repository;

import org.elsys.fatcatserver.module.AdminSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatcatServerAdminSettingsRepository extends JpaRepository<AdminSettings, Long> {

}
