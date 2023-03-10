package org.elsys.fatcatserver.controller;

import org.elsys.encryption.AES256;
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

import java.util.List;

@RestController
@RequestMapping("/api")
public class FatcatServerController {
    @Autowired
    FatcatServerService fatcatServerService;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public AdminSettings readAdminPanel(@RequestBody AdminSettings adminSettings){
        return fatcatServerService.setAdminSettings(adminSettings);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public AdminSettings getAdminSettings(){
        return fatcatServerService.getAdminSettings();
    }

    @RequestMapping(value = "/person/{sectorsid}", method = RequestMethod.GET)
    public List<Person> getPersonsInSector(@PathVariable(value = "sectorsid") Long sectorsId){
        return fatcatServerService.getPersonsInSector(sectorsId);
    }

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return fatcatServerService.createPerson(person);
    }
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public List<Person> readPerson(){
        return fatcatServerService.getPerson();
    }

    @RequestMapping(value = "/person/{personid}",method = RequestMethod.DELETE)
    public void delGETetePerson(@PathVariable(value = "personid") Long id){
        fatcatServerService.deletePerson(id);
    }

    @RequestMapping(value = "/sectors", method = RequestMethod.POST)
    public List<Sectors> createSectors(Sectors sector){
        String totalsectors = AES256.decrypt(fatcatServerService.getFatcatServerAdminSettingsRepository().getReferenceById(1L).getTotalsectors());

        for(int i = 0; i < Integer.parseInt(totalsectors) - 1; i++) {
            fatcatServerService.createSectors(sector);
        }

        return fatcatServerService.createSectors(sector);
    }
}