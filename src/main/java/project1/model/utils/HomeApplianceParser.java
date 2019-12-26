package project1.model.utils;

import project1.model.domain.entity.HomeAppliance;

import java.util.List;

public class HomeApplianceParser {
    public static String parseArray(List<HomeAppliance> devices) {
        StringBuilder str = new StringBuilder();
        for (HomeAppliance device : devices){
            str.append(device);
            str.append("\n");
        }
        return str.toString();
    }
}
