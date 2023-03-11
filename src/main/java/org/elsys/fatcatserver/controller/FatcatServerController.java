package org.elsys.fatcatserver.controller;

import org.elsys.fatcatserver.logic.GuardService;
import org.elsys.fatcatserver.module.AdminSettings;
import org.elsys.fatcatserver.module.Person;
import org.elsys.fatcatserver.module.Sectors;
import org.elsys.fatcatserver.service.FatcatServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FatcatServerController {
    @Autowired
    GuardService guardService;

    @Autowired
    FatcatServerService fatcatServerService;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public List<Sectors> readAdminPanel(@RequestBody AdminSettings adminSettings) {
        fatcatServerService.setAdminSettings(adminSettings);
        return fatcatServerService.createSectors();
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public AdminSettings getAdminSettings() {
        return fatcatServerService.getAdminSettings();
    }

    @RequestMapping(value = "/admin/sectorcnt", method = RequestMethod.GET)
    public int getSectorCnt() {
        return fatcatServerService.getSectorCnt();
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return fatcatServerService.createPerson(person);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> readPerson() {
        return fatcatServerService.getPerson();
    }

    @RequestMapping(value = "/person/{personid}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable(value = "personid") Long id) {
        fatcatServerService.deletePerson(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    public void deleteAllPersons() {
        fatcatServerService.deleteAllPersons();
    }

    @RequestMapping(value = "/setGuardDistribution", method = RequestMethod.GET)
    public List<Sectors> DistributeGuards() {
        return guardService.execute();
    }

    @RequestMapping(value = "/processData", method = RequestMethod.GET)
    public List<Integer> processData() {
        List<Sectors> arr = guardService.execute();
        return fatcatServerService.processData(arr);
    }

    @RequestMapping(value = "/sectors", method = RequestMethod.GET)
    public List<Sectors> getSectors() {
        return fatcatServerService.getSectors();
    }
}
