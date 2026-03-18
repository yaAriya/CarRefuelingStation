package validator;

import entity.Car;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateCar(Car car, int minTankFreeSpace, int maxTankFreeSpace) {
        return validateId(car.getId()) && validateTankFreeSpace(car.getTankFreeSpace(), minTankFreeSpace, maxTankFreeSpace);
    }

    public boolean validateId(long id) {
        return id > 0;
    }

    public boolean validateTankFreeSpace(int tankFreeSpace, int minTankFreeSpace, int maxTankFreeSpace) {
        return tankFreeSpace > minTankFreeSpace && tankFreeSpace <= maxTankFreeSpace;
    }

    @Override
    public boolean validateRefuelingParameters(int pumpsCount, int maxWaitTime, int carsCount, int minTankFreeSpace, int maxTankFreeSpace) {
        return validatePumpsCount(pumpsCount) && validateMaxWaitTime(maxWaitTime)
                && validateCarsCount(carsCount) && validateMinTankFreeSpace(minTankFreeSpace)
                && validateMaxTankFreeSpace(maxTankFreeSpace);
    }

    public boolean validatePumpsCount(int pumpsCount) {
        return pumpsCount > 0;
    }

    public boolean validateMaxWaitTime(int maxWaitTime) {
        return maxWaitTime > 0;
    }

    public boolean validateCarsCount(int carsCount) {
        return carsCount > 0;
    }

    public boolean validateMinTankFreeSpace(int minTankFreeSpace) {
        return minTankFreeSpace >= 0;
    }

    public boolean validateMaxTankFreeSpace(int maxTankFreeSpace) {
        return maxTankFreeSpace > 0;
    }
}
