package project1.controller;

import project1.model.service.HomeApplianceService;
import project1.view.HomeApplianceInput;
import project1.view.HomeApplienceView;

public class HomeApplianceController implements Runnable {
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
        view.viewData("Total energy consumption " + service.calculateTotalPowerConsumption());
        view.viewData("Home appliance sorted by energy consumption\n" + service.sortByPower());
        customFilterByPower();
    }

    private void customFilterByPower() {
        view.viewData("Please enter the beginning of the range");
        int beginning = input.nextInt();
        view.viewData("Please enter the end of the range");
        int end = input.nextInt();
        view.viewData("Home appliance with energy consumption in range\n" + service.filterByPower(beginning, end));
    }

}
