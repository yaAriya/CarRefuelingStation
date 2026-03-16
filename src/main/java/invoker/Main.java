package invoker;

import entity.Car;
import loader.RefuellingParametersLoader;
import task.RefuelTask;

public class Main {
    static void main() {
        RefuellingParametersLoader parametersLoader = new RefuellingParametersLoader();

        Car firstCar = new Car(0, 20);
        Car secondCar = new Car(1, 35);

        RefuelTask firstRefuelTask = new RefuelTask(firstCar);
        RefuelTask secondRefuelTask = new RefuelTask(secondCar);

        Thread firstThread = new Thread(firstRefuelTask);
        Thread secondThread = new Thread(secondRefuelTask);

        firstThread.start();
        secondThread.start();
    }
}
