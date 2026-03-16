package invoker;

import entity.Car;
import entity.RefuellingStation;
import loader.RefuellingParametersLoader;

public class Main {
    static void main() {
        RefuellingParametersLoader parametersLoader = new RefuellingParametersLoader();
        RefuellingStation refuellingStation = parametersLoader.loadParameters();

        Car firstCar = new Car(0, 50, 20, refuellingStation);
        Car secondCar = new Car(1, 60, 35, refuellingStation);

        firstCar.start();
        secondCar.start();
    }
}
