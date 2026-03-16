package validator;

import entity.Car;

public interface Validator {
    boolean validateRefuelingParameters(int pumpsCount, int maxWaitTime, int carsCount, int minTankValue, int maxTankValue);

    boolean validateCar(Car car);
}
