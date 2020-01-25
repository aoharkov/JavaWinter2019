package project1.model.utils;

import project1.model.domain.entity.Powerable;

import java.util.List;

public class HomeApplianceParser {
    public static String parseArray(List<Powerable> devices) {
        StringBuilder str = new StringBuilder();
        for (Powerable device : devices) {
            str.append(device);
            str.append("\n");
        }
        return str.toString();
    }
}
