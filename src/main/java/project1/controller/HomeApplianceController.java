package project1.controller;

import project1.model.service.HomeApplianceService;
import project1.view.HomeApplianceInput;
import project1.view.HomeApplianceView;
import project1.view.HomeApplianceViewLang;

public class HomeApplianceController implements Runnable {
    private HomeApplianceService service;
    private HomeApplianceView view;
    private HomeApplianceInput input;
    private HomeApplianceViewLang lang;

    public HomeApplianceController() {
        this.service = new HomeApplianceService();
        this.view = new HomeApplianceView();
        this.input = new HomeApplianceInput();
        this.lang = HomeApplianceViewLang.ENG;
    }

    @Override
    public void run() {
        demo();
        lang = HomeApplianceViewLang.UKR;
        demo();
    }

    private void demo() {
        view.viewData(lang.getTotalEnergyMessage() + service.calculateTotalPowerConsumption());
        view.viewData(lang.getSortedResultMessage() + service.sortByPower());
        customFilterByPower();
    }

    private void customFilterByPower() {
        view.viewData(lang.getRangeBeginningMessage());
        int beginning = input.nextInt();
        view.viewData(lang.getRangeEndMessage());
        int end = input.nextInt();
        view.viewData(lang.getRangeResultMessage() + service.filterByPower(beginning, end));
    }

    public HomeApplianceViewLang getLang() {
        return lang;
    }

    public void setLang(HomeApplianceViewLang lang) {
        this.lang = lang;
    }

}
