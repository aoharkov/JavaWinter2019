package project1.model.repository;

import project1.model.domain.ElectricGrid;
import project1.model.domain.entity.*;

import java.util.ArrayList;
import java.util.List;

public class HomeApplianceDataBase {
    public static List<Powerable> getInMemDataSet() {
        List<Powerable> result = new ArrayList<>();
        result.add(new HomeAppliance("Central air conditioner", 15000));
        result.add(new HomeAppliance("Clothes dryer", 4000));
        result.add(new HomeAppliance("Water heater", 3000));
        result.add(new HomeAppliance("Water pump", 1500));
        result.add(new HomeAppliance("Space heater", 1200));
        result.add(new SmallAppliance("Hair dryer", 1000, 1000));
        result.add(new HomeAppliance("Electric range burner", 1000));
        result.add(new MajorAppliance("Refrigerator", 1000, 200, 60, 55));
        result.add(new ConsumerElectronics("Desktop computer ", 400, true));
        result.add(new HomeAppliance("Light bulb", 60));
        return result;
    }
}
