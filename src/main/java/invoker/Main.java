package invoker;

import entity.Car;
import entity.RefuellingStation;
import loader.RefuellingParametersLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.StatisticsCollector;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    static void main() {
        LOGGER.info("Process run");
        RefuellingParametersLoader parametersLoader = new RefuellingParametersLoader();
        RefuellingStation refuellingStation = parametersLoader.loadParameters();

        int carsCount = refuellingStation.getCarsCount();
        List<Car> cars = new ArrayList<>();

        Car firstCar = new Car(1, 50, refuellingStation);
        cars.add(firstCar);
        Car secondCar = new Car(2, 40, refuellingStation);
        cars.add(secondCar);
        Car thirdCar = new Car(3, 30, refuellingStation);
        cars.add(thirdCar);
        Car fourthCar = new Car(4, 45, refuellingStation);
        cars.add(fourthCar);

        for (int i = 0; i < carsCount; i++) {
            cars.get(i).start();
        }

        try {
            for (Car car : cars) {
                car.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        StatisticsCollector statisticsCollector = new StatisticsCollector();
        statisticsCollector.logStatistic(carsCount, refuellingStation.getLeftCarsCount(), refuellingStation.getTotalWaitingTimeCounter());
        LOGGER.info("Process end");
    }
}
