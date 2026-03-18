package entity;

import exception.RefuellingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(Car.class);
    private final long id;
    private final int tankFreeSpace;
    private final RefuellingStation refuellingStation;

    public Car(long id, int tankFreeSpace, RefuellingStation refuellingStation) {
        this.id = id;
        this.tankFreeSpace = tankFreeSpace;
        this.refuellingStation = refuellingStation;
    }

    @Override
    public void run() {
        try {
            boolean success = refuellingStation.tryRefuel(this);
            if (success) {
                LOGGER.info("The car {} is refueled", id);
            } else {
                LOGGER.info("The car {} left without refueling", id);
            }
        } catch (RefuellingException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public long getId() {
        return id;
    }

    public int getTankFreeSpace() {
        return tankFreeSpace;
    }

    @Override
    public String toString() {
        return id + "," + tankFreeSpace;
    }
}
