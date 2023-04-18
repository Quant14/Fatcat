package org.elsys.fatcatserver.logic;

import org.elsys.fatcatserver.module.Person;
import org.elsys.fatcatserver.module.Sectors;
import org.elsys.fatcatserver.repository.FatcatServerAdminSettingsRepository;
import org.elsys.fatcatserver.repository.FatcatServerSectorsRepository;
import org.elsys.fatcatserver.service.FatcatServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GuardService {
    @Autowired
    FatcatServerAdminSettingsRepository fatcatServerAdminSettingsRepository;
    @Autowired
    FatcatServerService server_service;

    @Autowired
    FatcatServerSectorsRepository fatcatServerSectorsRepository;

    int number_of_sectors;
    int number_of_guards;
    Map<Integer, Integer> danger_of_sectors;
    int total_danger;

    @Autowired
    SectorDangerCalculater sectorDangerCalculater;

    public void setup_number_of() {
        Integer settings = fatcatServerAdminSettingsRepository.findAll().get(0).getTotalguards();
        number_of_guards = settings;
        settings = fatcatServerAdminSettingsRepository.findAll().get(0).getTotalsectors();
        number_of_sectors = settings;
    }

    public void setup_map() {
        List<Person> persons = server_service.getPerson();
        danger_of_sectors = new HashMap<>();
        for (int i = 1; i <= number_of_sectors; i++) {
            Long sector_id = (long) i;
            sectorDangerCalculater.setSectorPeople(server_service.getPersonsInSector(sector_id, persons));
            danger_of_sectors.put(i, sectorDangerCalculater.SectorDangerCalculation());

        }
    }

    public void total_danger_calculation() {
        int curr_total_danger = 0;
        for (int i = 1; i <= danger_of_sectors.size(); i++) {
            curr_total_danger += danger_of_sectors.get(i);
        }
        total_danger = curr_total_danger;
    }

    public void allocate_guards() {
        for (int i = 1; i <= number_of_sectors; i++) {
            int percentage = Math.round((float) danger_of_sectors.get(i) / total_danger * 100);
            double guards_for_this_sector = number_of_guards * ((float) percentage / 100);
            guards_for_this_sector = Math.round(guards_for_this_sector);
            fatcatServerSectorsRepository.findAll().get(i - 1).setGuards((int) guards_for_this_sector);
        }
        fatcatServerSectorsRepository.flush();
    }

    public List<Sectors> execute() {
        setup_number_of();
        setup_map();
        total_danger_calculation();
        allocate_guards();
        return server_service.getSectors();
    }
}