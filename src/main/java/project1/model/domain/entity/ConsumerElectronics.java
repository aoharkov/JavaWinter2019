package project1.model.domain.entity;

/**
 * Consumer electronics or home electronics are electronic
 * (analog or digital) equipment intended for everyday use,
 * typically in private homes.
 * <p>
 * Consumer electronics include devices used for:
 * entertainment (flatscreen TVs, DVD players, video games, remote control cars, etc.),
 * communications (telephones, cell phones, e-mail-capable laptops, etc.),
 * and home-office activities (e.g., desktop computers, printers, paper shredders, etc.).
 *
 * @see <a href="https://en.wikipedia.org/wiki/Consumer_electronics">Corresponding article in the English wikipedia</a>
 */
public class ConsumerElectronics extends HomeAppliance {
    /**
     * Contains {@code true} if the device has an internet connection,
     * and {@code false} otherwise
     */
    private boolean internetConnection;

    public ConsumerElectronics(String name, int power, boolean internetConnection) {
        super(name, power);
        this.internetConnection = internetConnection;
    }

    public boolean isInternetConnection() {
        return internetConnection;
    }

    public void setInternetConnection(boolean internetConnection) {
        this.internetConnection = internetConnection;
    }
}
