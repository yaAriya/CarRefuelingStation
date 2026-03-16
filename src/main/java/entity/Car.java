package entity;

import exception.RefuellingException;

public class Car extends Thread {
    private final int id;
    private final int tankVolume;
    private final int tankFreeSpace;
    private final RefuellingStation refuellingStation;

    public Car(int id, int tankValue, int tankFreeSpace, RefuellingStation refuellingStation) {
        this.id = id;
        this.tankVolume = tankValue;
        this.tankFreeSpace = tankFreeSpace;
        this.refuellingStation = refuellingStation;
    }

    @Override
    public void run() {
        try {
            boolean success = refuellingStation.tryRefuel(this);
            if (success) {
                System.out.println("Машина " + threadId() + " Заправлена");
            } else {
                System.out.println("Машина " + threadId() + " уехала не заправившись");
            }
        } catch (RefuellingException e){
            throw new RuntimeException();
        }
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public int getTankFreeSpace() {
        return tankFreeSpace;
    }

    @Override
    public String toString() {
        return id + "," + tankFreeSpace;
    }
}
