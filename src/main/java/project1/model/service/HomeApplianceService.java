package project1.model.service;

import project1.model.domain.ElectricGrid;
import project1.model.repository.HomeApplianceDataBase;
import project1.model.utils.HomeApplianceParser;

public class HomeApplianceService {
    private ElectricGrid electricGrid;

    public HomeApplianceService() {
        this.electricGrid = new ElectricGrid(HomeApplianceDataBase.getInMemDataSet());
    }

    public String getUsedPower() {
        return Integer.toString(electricGrid.getUsedPower());
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
