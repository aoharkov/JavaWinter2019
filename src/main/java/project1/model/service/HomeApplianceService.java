package project1.model.service;

import project1.model.domain.ElectricGrid;
import project1.model.utils.HomeApplianceParser;

public class HomeApplianceService {
    private ElectricGrid electricGrid;

    public HomeApplianceService(ElectricGrid electricGrid) {
        this.electricGrid = electricGrid;
    }

    public String calculateTotalPowerConsumption() {
        return Integer.toString(electricGrid.calculateTotalPowerConsumption());
    }

    public String sortByPower() {
        return HomeApplianceParser.parseArray(electricGrid.sortByPower());
    }

    public String filterByPower(int from, int to) {
        return HomeApplianceParser.parseArray(electricGrid.filterByPower(from, to));
    }

    public ElectricGrid getElectricGrid() {
        return electricGrid;
    }

    public void setElectricGrid(ElectricGrid electricGrid) {
        this.electricGrid = electricGrid;
    }
}
