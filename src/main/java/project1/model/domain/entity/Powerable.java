package project1.model.domain.entity;

public interface Powerable {
    /**
     * Returns typical consumption of power per hour, in watts.
     */
    int getPower();

    /**
     * Set typical consumption of power per hour, in watts.
     */
    void setPower(int power);
}
