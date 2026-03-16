package entity;

public class Car {
    private int id;
    private int tankFreeSpace;

    public Car (int id, int tankFreeSpace){
        this.id = id;
        this.tankFreeSpace = tankFreeSpace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTankFreeSpace() {
        return tankFreeSpace;
    }

    public void setTankFreeSpace(int tankFreeSpace) {
        this.tankFreeSpace = tankFreeSpace;
    }

    @Override
    public String toString() {
        return id + "," + tankFreeSpace;
    }
}
