package project1.controller;

import project1.model.service.HomeApplianceService;
import project1.view.HomeApplianceInput;
import project1.view.HomeApplianceView;
import project1.view.HomeApplianceViewLang;

public class HomeApplianceController implements Runnable {
    private final HomeApplianceService service;
    private final HomeApplianceView view;
    private final HomeApplianceInput input;
    private HomeApplianceViewLang lang;

    private HomeApplianceController(HomeApplianceControllerBuilder builder) {
        this.service = builder.service;
        this.view = builder.view;
        this.input = builder.input;
        this.lang = builder.lang;
    }

    public static HomeApplianceControllerBuilder builder() {
        return new HomeApplianceControllerBuilder();
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

    public static final class HomeApplianceControllerBuilder {
        private HomeApplianceService service;
        private HomeApplianceView view;
        private HomeApplianceInput input;
        private HomeApplianceViewLang lang;

        private HomeApplianceControllerBuilder() {
        }

        public HomeApplianceControllerBuilder withService(HomeApplianceService service) {
            this.service = service;
            return this;
        }

        public HomeApplianceControllerBuilder withView(HomeApplianceView view) {
            this.view = view;
            return this;
        }

        public HomeApplianceControllerBuilder withInput(HomeApplianceInput input) {
            this.input = input;
            return this;
        }

        public HomeApplianceControllerBuilder withLang(HomeApplianceViewLang lang) {
            this.lang = lang;
            return this;
        }

        public HomeApplianceController build() {
            return new HomeApplianceController(this);
        }
    }
}
