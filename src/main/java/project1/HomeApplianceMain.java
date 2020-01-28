package project1;

import project1.controller.HomeApplianceController;
import project1.model.domain.ElectricGrid;
import project1.model.repository.HomeApplianceDataBase;
import project1.model.service.HomeApplianceService;
import project1.view.HomeApplianceInput;
import project1.view.HomeApplianceView;
import project1.view.HomeApplianceViewLang;

public class HomeApplianceMain {
    public static void main(String[] args) {
        HomeApplianceController.builder()
                .withService(new HomeApplianceService(new ElectricGrid(HomeApplianceDataBase.getInMemDataSet())))
                .withView(new HomeApplianceView())
                .withInput(new HomeApplianceInput())
                .withLang(HomeApplianceViewLang.ENG)
                .build()
                .run();
    }
}
