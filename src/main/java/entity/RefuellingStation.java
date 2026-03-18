package entity;

import exception.InvalidParametersException;
import exception.RefuellingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.Validator;
import validator.ValidatorImpl;

import java.util.concurrent.locks.ReentrantLock;

public class RefuellingStation {
    private static final Logger LOGGER = LogManager.getLogger(RefuellingStation.class);
    private final ReentrantLock[] pumps;
    private final int pumpsCount;
    private final int maxWaitTime;
    private final int carsCount;
    private final int minTankFreeSpace;
    private final int maxTankFreeSpace;

    public RefuellingStation(int pumpsCount, int maxWaitTime, int carsCount, int minTankFreeSpace, int maxTankFreeSpace) {
        this.pumpsCount = pumpsCount;
        this.maxWaitTime = maxWaitTime;
        this.pumps = new ReentrantLock[pumpsCount];
        for (int i = 0; i < pumpsCount; i++) {
            pumps[i] = new ReentrantLock();
        }
        this.carsCount = carsCount;
        this.minTankFreeSpace = minTankFreeSpace;
        this.maxTankFreeSpace = maxTankFreeSpace;

        LOGGER.info("Parameters are set");
    }

    public boolean tryRefuel(Car car) throws RefuellingException {
        Validator validator = new ValidatorImpl();
        try {
            if (validator.validateCar(car, minTankFreeSpace, maxTankFreeSpace)) {
                long arrivalTime = System.currentTimeMillis();

                while (System.currentTimeMillis() - arrivalTime < maxWaitTime) {
                    for (ReentrantLock pump : pumps) {
                        if (pump.tryLock()) {
                            try {
                                LOGGER.info("The {} car is refueling at {} pump", car.getId(), pump);
                                Thread.sleep((long) car.getTankFreeSpace() * 10);
                                return true;
                            } finally {
                                pump.unlock();
                            }
                        }
                    }
                    Thread.sleep(50);
                }
                return false;
            } else {
                LOGGER.error("Invalid parameters");
                throw new InvalidParametersException();
            }
        } catch (InvalidParametersException | InterruptedException e) {
            LOGGER.error("Refueling problems");
            throw new RefuellingException(e);
        }
    }

    public ReentrantLock[] getPumps() {
        return pumps;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public int getPumpsCount() {
        return pumpsCount;
    }

    public int getCarsCount() {
        return carsCount;
    }
}
