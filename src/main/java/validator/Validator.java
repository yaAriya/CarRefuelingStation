package validator;

import entity.Car;

public interface Validator {
    boolean validateRefuelingParameters(int pumpsCount, int maxWaitTime, int carsCount, int minTankFreeSpace, int maxTankFreeSpace);

    boolean validateCar(Car car, int minTankFreeSpace, int maxTankFreeSpace);
}
