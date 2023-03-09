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

    public List<Person> getEmployees() {
        return fatcatServerRepository.findAll();
    }

    public void deleteEmployee(int personId) {
        fatcatServerRepository.deleteById(personId);
    }
}
