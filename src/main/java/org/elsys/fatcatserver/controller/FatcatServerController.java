package org.elsys.fatcatserver.controller;

import org.elsys.fatcatserver.*;
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

    //@RequestMapping(value = "/admin", method = RequestMethod.POST)
    //public void readAdminPanel(@RequestBody )

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public Person creatPerson(@RequestBody Person person) {
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

    /*@RequestMapping(value = "/sectors", method = RequestMethod.POST)
    public LinkedList<String> readSectors(@RequestBody LinkedList<String> sectors){ return fatcatServerService.setSectors(sectors); }*/
}
