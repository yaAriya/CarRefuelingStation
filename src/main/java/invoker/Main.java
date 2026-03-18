package invoker;

import entity.Car;
import entity.RefuellingStation;
import loader.RefuellingParametersLoader;

public class Main {
    static void main() {
        RefuellingParametersLoader parametersLoader = new RefuellingParametersLoader();
        RefuellingStation refuellingStation = parametersLoader.loadParameters();

        Car firstCar = new Car(1, 50, refuellingStation);
        Car secondCar = new Car(2, 40, refuellingStation);
        Car thirdCar = new Car(3, 30, refuellingStation);
        Car fourthCar = new Car(4, 45, refuellingStation);

        firstCar.start();
        secondCar.start();
        thirdCar.start();
        fourthCar.start();
    }
}
