package org.elsys.fatcatserver.service;

import org.elsys.fatcatserver.encryption.AES256;
import org.elsys.fatcatserver.module.AdminSettings;
import org.elsys.fatcatserver.module.Person;
import org.elsys.fatcatserver.module.Sectors;
import org.elsys.fatcatserver.repository.FatcatServerAdminSettingsRepository;
import org.elsys.fatcatserver.repository.FatcatServerSectorsRepository;
import org.elsys.fatcatserver.repository.FatcatServerPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class FatcatServerService {
    @Autowired
    AES256 AES256;
    @Autowired
    FatcatServerPersonRepository fatcatServerPersonRepository;
    @Autowired
    FatcatServerAdminSettingsRepository fatcatServerAdminSettingsRepository;
    @Autowired
    FatcatServerSectorsRepository fatcatServerSectorsRepository;

    public AdminSettings setAdminSettings(AdminSettings adminSettings) {
        fatcatServerAdminSettingsRepository.deleteAll();
        adminSettings.setTotalguards(AES256.encrypt(adminSettings.getTotalguards()));
        adminSettings.setTotalsectors(AES256.encrypt(adminSettings.getTotalsectors()));
        return fatcatServerAdminSettingsRepository.save(adminSettings);
    }

    public AdminSettings getAdminSettings() {
        AdminSettings res = fatcatServerAdminSettingsRepository.findAll().get(0);
        res.setTotalguards(AES256.decrypt(res.getTotalguards()));
        res.setTotalsectors(AES256.decrypt(res.getTotalsectors()));

        return res;
    }

    public List<Person> getPersonsInSector(Long sectorsId, List<Person> persons) {
        List<Person> res = new LinkedList<>();

        persons.stream()
                .filter(curr -> Objects.equals(curr.getSector(), Long.toString(sectorsId)))
                .forEach(res::add);
        return res;
    }

    public Person createPerson(Person person) {
        person.setName(AES256.encrypt(person.getName()));
        person.setSector(AES256.encrypt(person.getSector()));
        person.setDescription(AES256.encrypt(person.getDescription()));
        person.setDanger(AES256.encrypt(person.getDanger()));
        return fatcatServerPersonRepository.save(person);
    }

    public List<Person> getPerson() {
        List<Person> tempList = new LinkedList<>();

        for (Person person : fatcatServerPersonRepository.findAll()) {
            tempList.add(new Person(AES256.decrypt(person.getName()),
                    AES256.decrypt(person.getSector()),
                    AES256.decrypt(person.getDescription()),
                    AES256.decrypt(person.getDanger())));
        }
        return tempList;
    }

    public void deletePerson(Long personId) {
        fatcatServerPersonRepository.deleteById(personId);
    }

    public List<Sectors> createSectors() {
        fatcatServerSectorsRepository.deleteAll();
        String totalsectors = AES256.decrypt(fatcatServerAdminSettingsRepository.findAll().get(0).getTotalsectors());

        for (int i = 0; i < Integer.parseInt(totalsectors); i++) {
            Sectors newSector = new Sectors();
            fatcatServerSectorsRepository.save(newSector);
        }

        return fatcatServerSectorsRepository.findAll();
    }

    public List<Sectors> getSectors() {
        List<Sectors> tempList = new LinkedList<>();

        for (Sectors sector : fatcatServerSectorsRepository.findAll()) {
            tempList.add(new Sectors(AES256.decrypt(sector.getGuards())));

        }
        return tempList;
    }

    public int getSectorCnt() {
        return Integer.parseInt(AES256.decrypt(fatcatServerAdminSettingsRepository.findAll().get(0).getTotalsectors()));
    }

    public void deleteAllPersons() {
        fatcatServerPersonRepository.deleteAll();
    }

    public List<Integer> processData(List<Sectors> sectors) {
        List<Integer> res = new ArrayList<>();

        for (Sectors sector : sectors) {
            res.add(Integer.valueOf(sector.getGuards()));
        }

        return res;
    }

}