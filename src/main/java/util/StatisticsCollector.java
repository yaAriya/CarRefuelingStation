package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatisticsCollector {
    private static final Logger LOGGER = LogManager.getLogger(StatisticsCollector.class);

    public void logStatistic(int carsCount, int leftCarsCount, long totalWaitingTime) {
        LOGGER.info("{} out of {} cars left without refueling", leftCarsCount, carsCount);
        long refueledCarsCount = carsCount - leftCarsCount;
        LOGGER.info("{} cars was refueled", refueledCarsCount);
        long averageWaitingTime = totalWaitingTime / carsCount;
        LOGGER.info("Average waiting time was {}", averageWaitingTime);
    }
}
