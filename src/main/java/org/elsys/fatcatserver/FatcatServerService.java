package org.elsys.fatcatserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatcatServerService {
    @Autowired
    FatcatServerRepository fatcatServerRepository;

    public Person createPerson(Person person) {
        return fatcatServerRepository.save(person);
    }

    public List<Person> getPerson() {
        return fatcatServerRepository.findAll();
    }

    public void deletePerson(Long personId) {
        fatcatServerRepository.deleteById(personId);
    }
}
