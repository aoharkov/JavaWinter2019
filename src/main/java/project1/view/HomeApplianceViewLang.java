package project1.view;

public enum HomeApplianceViewLang {
    ENG(
            "Total energy consumption = ",
            "Home appliance sorted by energy consumption:\n",
            "Please enter the beginning of the range:",
            "Please enter the end of the range:",
            "Home appliance with energy consumption in range:\n"),
    UKR(
            "Загальне споживання електроенергії = ",
            "Побутові прилади відсортовані за споживанням електроенергії:\n",
            "Будь ласка, введіть початок діапазону:",
            "Будь ласка, введіть кінець діапазону:",
            "Побутові прилади із споживанням електроенергії у заданому діапазоні:\n");

    private String totalEnergyMessage;
    private String sortedResultMessage;
    private String rangeBeginningMessage;
    private String rangeEndMessage;
    private String rangeResultMessage;

    HomeApplianceViewLang(String totalEnergyMessage, String sortedResultMessage, String rangeBeginningMessage, String rangeEndMessage, String rangeResultMessage) {
        this.totalEnergyMessage = totalEnergyMessage;
        this.sortedResultMessage = sortedResultMessage;
        this.rangeBeginningMessage = rangeBeginningMessage;
        this.rangeEndMessage = rangeEndMessage;
        this.rangeResultMessage = rangeResultMessage;
    }

    public String getTotalEnergyMessage() {
        return totalEnergyMessage;
    }

    public String getSortedResultMessage() {
        return sortedResultMessage;
    }

    public String getRangeBeginningMessage() {
        return rangeBeginningMessage;
    }

    public String getRangeEndMessage() {
        return rangeEndMessage;
    }

    public String getRangeResultMessage() {
        return rangeResultMessage;
    }
}
