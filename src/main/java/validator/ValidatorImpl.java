package validator;

import entity.Car;

public class ValidatorImpl implements Validator {
    @Override
    public boolean validateCar(Car car) {
        return validateId(car.threadId()) && validateTankVolume(car.getTankVolume())
                && validateTankFreeSpace(car.getTankFreeSpace());
    }

    public boolean validateId(long id) {
        return id > 0;
    }

    public boolean validateTankVolume(int tankVolume){
        return tankVolume > 0;
    }

    public boolean validateTankFreeSpace(int tankFreeSpace) {
        return tankFreeSpace > 10 && tankFreeSpace < 50;
    }

    @Override
    public boolean validateRefuelingParameters(int pumpsCount, int maxWaitTime, int carsCount, int minTankValue, int maxTankValue){
        return validatePumpsCount(pumpsCount) && validateMaxWaitTime(maxWaitTime)
                && validateCarsCount(carsCount) && validateMinTankValue(minTankValue)
                && validateMaxTankValue(maxTankValue);
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


    public boolean validateMinTankValue(int minTankValue) {
        return minTankValue >= 0;
    }

    public boolean validateMaxTankValue(int maxTankValue) {
        return maxTankValue > 0;
    }
}
