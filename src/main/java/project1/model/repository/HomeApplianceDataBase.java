package project1.model.repository;

import project1.model.domain.entity.ConsumerElectronics;
import project1.model.domain.entity.HomeAppliance;
import project1.model.domain.entity.MajorAppliance;
import project1.model.domain.entity.Powerable;
import project1.model.domain.entity.SmallAppliance;

import java.util.ArrayList;
import java.util.List;

public class HomeApplianceDataBase {

    public static List<Powerable> getInMemDataSet() {
        List<Powerable> result = new ArrayList<>();
        result.add(new MajorAppliance("Refrigerator", 1000, 200, 60, 55));
        result.add(new SmallAppliance("Hair dryer", 1000, 1000));
        result.add(new ConsumerElectronics("Desktop computer ", 400, true));
        result.add(new HomeAppliance("Light bulb", 60));
        result.add(new HomeAppliance("Central air conditioner", 15000));
        result.add(new MajorAppliance("Washing machine", 4000, 100, 80, 80));
        result.add(new HomeAppliance("Water heater", 3000));
        result.add(new HomeAppliance("Water pump", 1500));
        result.add(new HomeAppliance("Space heater", 1200));
        result.add(new MajorAppliance("Electric stove", 1000, 30, 70, 70));
        return result;
    }
}
