package project1.model.domain;

import project1.model.domain.entity.Powerable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectricGrid {
    private List<Powerable> devices;

    public ElectricGrid(List<Powerable> devices) {
        this.devices = devices;
    }

    public int calculateTotalPowerConsumption() {
        int sum = 0;
        for (Powerable device : devices) {
            sum += device.getPower();
        }
        return sum;
    }

    public List<Powerable> sortByPower() {
        devices.sort(new Comparator<Powerable>() {
            @Override
            public int compare(Powerable o1, Powerable o2) {
                return o2.getPower() - o1.getPower();
            }
        });
        return devices;
    }

    public List<Powerable> filterByPower(int from, int to) {
        if (from > to) {
            return null;
        }
        List<Powerable> result = new ArrayList<>();
        for (Powerable device : devices) {
            int power = device.getPower();
            if (power >= from && power <= to) {
                result.add(device);
            }
        }
        return result;
    }

    public List<Powerable> getDevices() {
        return devices;
    }

    public void setDevices(List<Powerable> devices) {
        this.devices = devices;
    }
}
