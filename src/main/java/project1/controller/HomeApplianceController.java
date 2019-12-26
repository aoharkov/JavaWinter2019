package project1.controller;

import project1.model.service.HomeApplianceService;
import project1.view.HomeApplianceInput;
import project1.view.HomeApplienceView;

public class HomeApplianceController implements Runnable{
    private HomeApplianceService service;
    private HomeApplienceView view;
    private HomeApplianceInput input;

    public HomeApplianceController() {
        this.service = new HomeApplianceService();
        this.view = new HomeApplienceView();
        this.input = new HomeApplianceInput();
    }

    @Override
    public void run() {
        view.viewData(service.sortByPower());
        view.viewData(service.calculateTotalPowerConsumption());
        view.viewData(service.filterByPower(100, 1000));
    }
}
