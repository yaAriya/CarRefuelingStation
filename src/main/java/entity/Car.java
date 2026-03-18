package entity;

import exception.RefuellingException;

public class Car extends Thread {
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
                System.out.println("Машина " + getId() + " Заправлена");
            } else {
                System.out.println("Машина " + getId() + " уехала не заправившись");
            }
        } catch (RefuellingException e){
            throw new RuntimeException();
        }
    }

    @Override
    public long getId(){
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
