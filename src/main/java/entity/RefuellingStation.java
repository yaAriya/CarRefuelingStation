package entity;

import exception.InvalidParametersException;
import exception.RefuellingException;
import validator.Validator;
import validator.ValidatorImpl;

import java.util.concurrent.locks.ReentrantLock;

public class RefuellingStation {
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


        System.out.println("Parameters are set");
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
                                System.out.println(car.getId() + " Занял колонку " + pump);
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
                throw new InvalidParametersException();
            }
        } catch (InvalidParametersException | InterruptedException e) {
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
