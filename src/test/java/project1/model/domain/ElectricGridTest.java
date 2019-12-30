package project1.model.domain;

import org.junit.Before;
import org.junit.Test;
import project1.model.domain.entity.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ElectricGridTest {
    private ElectricGrid electricGrid;

    @Before
    public void setUp() {
        List<Powerable> devices = new ArrayList<>();
        devices.add(new MajorAppliance("Refrigerator", 1000, 200, 60, 55));
        devices.add(new SmallAppliance("Hair dryer", 2000, 1000));
        devices.add(new ConsumerElectronics("Desktop computer ", 400, true));
        devices.add(new HomeAppliance("Light bulb", 60));
        devices.add(new HomeAppliance("Water heater", 3000));
        devices.add(new HomeAppliance("Central air conditioner", 15000));
        electricGrid = new ElectricGrid(devices);
    }

    @Test
    public void testCalculateTotalPowerConsumption() {
        assertEquals(21460, electricGrid.calculateTotalPowerConsumption());
    }

    @Test
    public void testSortByPower() {
        List<Powerable> sortedDevices = new ArrayList<>();
        sortedDevices.add(new HomeAppliance("Central air conditioner", 15000));
        sortedDevices.add(new HomeAppliance("Water heater", 3000));
        sortedDevices.add(new SmallAppliance("Hair dryer", 2000, 1000));
        sortedDevices.add(new MajorAppliance("Refrigerator", 1000, 200, 60, 55));
        sortedDevices.add(new ConsumerElectronics("Desktop computer ", 400, true));
        sortedDevices.add(new HomeAppliance("Light bulb", 60));
        assertArrayEquals(sortedDevices.toArray(), electricGrid.sortByPower().toArray());
    }

    @Test
    public void testFilterByPower() {
        List<Powerable> sortedDevices = new ArrayList<>();
        sortedDevices.add(new MajorAppliance("Refrigerator", 1000, 200, 60, 55));
        sortedDevices.add(new SmallAppliance("Hair dryer", 2000, 1000));
        assertArrayEquals(sortedDevices.toArray(), electricGrid.filterByPower(800, 2400).toArray());
    }
}