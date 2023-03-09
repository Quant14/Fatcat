package org.elsys.fatcatserver;
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

    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public Person creatPerson(@RequestBody Person person) {
        return fatcatServerService.createPerson(person);
    }
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public List<Person> readPerson(){
        return fatcatServerService.getPerson();
    }

    @RequestMapping(value = "/person/{personid}",method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable(value = "personid") Long id){
        fatcatServerService.deletePerson(id);
    }
}
