package task;

import entity.Car;

public class RefuelTask implements Runnable {
    private int carsCount;
    private int pumpsCount;
    private int maxWaitTime;
    private int minTankValue;
    private int maxTankValue;
    private Car car;

    public RefuelTask() {
    }

    public RefuelTask(Car car) {
        this.car = car;
    }

    public RefuelTask(int pumpsCount, int maxWaitTime, int carsCount, int minTankValue, int maxTankValue) {
        this.pumpsCount = pumpsCount;
        this.maxWaitTime = maxWaitTime;
        this.carsCount = carsCount;
        this.minTankValue = minTankValue;
        this.maxTankValue = maxTankValue;
        System.out.println("Parameters are set");
    }


    @Override
    public void run() {
        for (int i = 0; i < carsCount; i++) {
            System.out.println("Машина " + this.getCar().getId() + " Заправлена");
        }
    }

    public int getCarsCount() {
        return carsCount;
    }

    public int getPumpsCount() {
        return pumpsCount;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public int getMinTankValue() {
        return minTankValue;
    }

    public int getMaxTankValue() {
        return maxTankValue;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
