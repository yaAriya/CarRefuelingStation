package entity;

import java.util.concurrent.locks.ReentrantLock;

public class RefuellingStation {
    private ReentrantLock[] pumps;

    public RefuellingStation(ReentrantLock[] pumps) {
        this.pumps = pumps;
    }


    public ReentrantLock[] getPumps() {
        return pumps;
    }
}
