package project1.model.domain;

import project1.model.domain.entity.HomeAppliance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectricGrid {
    private List<HomeAppliance> devices;

    public ElectricGrid(List<HomeAppliance> devices) {
        this.devices = devices;
    }

    public int getUsedPower() {
        int sum = 0;
        for (HomeAppliance device : devices) {
            sum += device.getPower();
        }
        return sum;
    }

    public List<HomeAppliance> sortByPower() {
        devices.sort(new Comparator<HomeAppliance>() {
            @Override
            public int compare(HomeAppliance o1, HomeAppliance o2) {
                return o2.getPower() - o1.getPower();
            }
        });
        return devices;
    }

    public List<HomeAppliance> filterByPower(int from, int to){
        if (from > to) {
            return null;
        }
        List<HomeAppliance> result = new ArrayList<>();
        for (HomeAppliance device : devices) {
            int power = device.getPower();
            if (power >= from && power <= to) {
                result.add(device);
            }
        }
        return result;
    }

    public List<HomeAppliance> getDevices() {
        return devices;
    }

    public void setDevices(List<HomeAppliance> devices) {
        this.devices = devices;
    }
}
