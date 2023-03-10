package org.elsys.fatcatserver.service;

import org.elsys.encryption.AES256;
import org.elsys.fatcatserver.module.AdminSettings;
import org.elsys.fatcatserver.module.Person;
import org.elsys.fatcatserver.repository.FatcatServerAdminSettingsRepository;
import org.elsys.fatcatserver.repository.FatcatServerSectorsRepository;
import org.elsys.fatcatserver.repository.FatcatServerPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class FatcatServerService {

    @Autowired
    FatcatServerPersonRepository fatcatServerPersonRepository;
    FatcatServerAdminSettingsRepository fatcatServerGuardsRepository;
    FatcatServerSectorsRepository fatcatServerSectorsRepository;

    public AdminSettings setAdminSettings(AdminSettings adminSettings){
        adminSettings.setTotalguards(AES256.encrypt(adminSettings.getTotalguards()));
        adminSettings.setTotalguards(AES256.encrypt(adminSettings.getTotalguards()));
        return fatcatServerGuardsRepository.save(adminSettings);
    }

    public List<Person> getPersonsInSector(Long sectorsId){
        List<Person> res = new LinkedList<>();

        getPerson().stream()
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
        List<Person> tempList = fatcatServerPersonRepository.findAll();
        for (Person person : tempList) {
            person.setName(AES256.decrypt(person.getName()));
            person.setSector(AES256.decrypt(person.getSector()));
            person.setDescription(AES256.decrypt(person.getDescription()));
            person.setDanger(AES256.decrypt(person.getDanger()));
        }
        return tempList;
    }

    public void deletePerson(Long personId) {
        fatcatServerPersonRepository.deleteById(personId);
    }

    /*public LinkedList<String> setSectors(LinkedList<String> sectors){
        return processData.setSectors(sectors);
    }*/
}
