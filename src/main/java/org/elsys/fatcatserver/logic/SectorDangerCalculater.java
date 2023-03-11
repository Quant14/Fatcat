package org.elsys.fatcatserver.logic;

import org.elsys.fatcatserver.module.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorDangerCalculater {
    public void setSectorPeople(List<Person> sectorPeople) {
        SectorPeople = sectorPeople;
    }

    List<Person> SectorPeople;

    int SectorDangerCalculation() {
        int DangerLevel = 0;
        for (int i = 0; i < SectorPeople.size(); i++) {
            DangerLevel += Integer.parseInt(SectorPeople.get(i).getDanger());

        }
        return DangerLevel;
    }
}
