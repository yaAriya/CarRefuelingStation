package entity;

import exception.InvalidParametersException;
import exception.RefuellingException;
import validator.Validator;
import validator.ValidatorImpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RefuellingStation {
    private final ReentrantLock[] pumps;
    private final int pumpsCount;
    private final int maxWaitTime;
    private final int carsCount;
    private final int minTankValue;
    private final int maxTankValue;

    public RefuellingStation(int pumpsCount, int maxWaitTime, int carsCount, int minTankValue, int maxTankValue) {
        this.pumpsCount = pumpsCount;
        this.maxWaitTime = maxWaitTime;
        this.pumps = new ReentrantLock[pumpsCount];
        for (int i = 0; i < pumpsCount; i++) {
            pumps[i] = new ReentrantLock();
        }
        this.carsCount = carsCount;
        this.minTankValue = minTankValue;
        this.maxTankValue = maxTankValue;
        System.out.println("Parameters are set");
    }


    public boolean tryRefuel(Car car) throws RefuellingException{
        Validator validator = new ValidatorImpl();
        try {
            if (validator.validateCar(car)) {
                for (ReentrantLock pump : pumps) {
                    try {
                        if (pump.tryLock(maxWaitTime, TimeUnit.MILLISECONDS)) {
                            Thread.sleep((long) car.getTankFreeSpace() * 10);
                            System.out.println(car.threadId() + " Занял колонку");
                        }
                    } finally {
                        pump.unlock();
                    }
                }
                return false;
            } else {
                throw new InvalidParametersException();
            }
        } catch (InvalidParametersException | InterruptedException e){
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

    public int getMinTankValue() {
        return minTankValue;
    }

    public int getMaxTankValue() {
        return maxTankValue;
    }
}
