package org.elsys.fatcatserver.service;

import org.elsys.encryption.AES256;
import org.elsys.fatcatserver.module.Person;
import org.elsys.fatcatserver.repository.FatcatServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatcatServerService {

    @Autowired
    FatcatServerRepository fatcatServerRepository;

    public Person createPerson(Person person) {
        person.setName(AES256.encrypt(person.getName()));
        person.setSector(AES256.encrypt(person.getSector()));
        person.setDescription(AES256.encrypt(person.getDescription()));
        person.setDanger(AES256.encrypt(person.getDanger()));
        return fatcatServerRepository.save(person);
    }

    public List<Person> getPerson() {
        List<Person> tempList = fatcatServerRepository.findAll();
        for(int i = 0; i < tempList.size(); i++) {
            tempList.get(i).setName(AES256.decrypt(tempList.get(i).getName()));
            tempList.get(i).setSector(AES256.decrypt(tempList.get(i).getSector()));
            tempList.get(i).setDescription(AES256.decrypt(tempList.get(i).getDescription()));
            tempList.get(i).setDanger(AES256.decrypt(tempList.get(i).getDanger()));
        }
        return tempList;
    }

    public void deletePerson(Long personId) {
        fatcatServerRepository.deleteById(personId);
    }

    /*public LinkedList<String> setSectors(LinkedList<String> sectors){
        return processData.setSectors(sectors);
    }*/
}
