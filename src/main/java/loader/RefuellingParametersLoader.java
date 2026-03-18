package loader;

import entity.RefuellingStation;
import exception.InvalidParametersException;
import exception.LoaderException;
import validator.Validator;
import validator.ValidatorImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RefuellingParametersLoader {
    private static final String FILE_PATH = "src/main/resources/refuelingParameters.properties";
    private final Validator validator = new ValidatorImpl();
    private int pumpsCount;
    private int maxWaitTime;

    private int carsCount;
    private int minTankFreeSpace;
    private int maxTankFreeSpace;

    public RefuellingStation loadParameters() throws LoaderException {
        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream(FILE_PATH);
            properties.load(inputStream);
            inputStream.close();

            String stringFuelPumpsCount = properties.getProperty("fuelPumpsCount");
            pumpsCount = Integer.parseInt(stringFuelPumpsCount);

            String stringMaxWaitTime = properties.getProperty("maxWaitTime");
            maxWaitTime = Integer.parseInt(stringMaxWaitTime);

            String StringCarsCount = properties.getProperty("carsCount");
            carsCount = Integer.parseInt(StringCarsCount);

            String stringMinTankFreeSpace = properties.getProperty("minTankFreeSpace");
            minTankFreeSpace = Integer.parseInt(stringMinTankFreeSpace);

            String stringMaxTankFreeSpace  = properties.getProperty("maxTankFreeSpace");
            maxTankFreeSpace = Integer.parseInt(stringMaxTankFreeSpace);

            boolean parametersIsValid = validator.validateRefuelingParameters(pumpsCount, maxWaitTime, carsCount, minTankFreeSpace, maxTankFreeSpace);
            if (parametersIsValid) {
                RefuellingStation refuellingStation = new RefuellingStation(pumpsCount, maxWaitTime, carsCount, minTankFreeSpace, maxTankFreeSpace);
                return refuellingStation;
            } else {
                throw new InvalidParametersException("Your parameters are invalid");
            }
        } catch (IOException | InvalidParametersException e) {
            throw new LoaderException(e);
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

    public int getMinTankFreeSpace() {
        return minTankFreeSpace;
    }

    public int getMaxTankFreeSpace() {
        return maxTankFreeSpace;
    }
}
