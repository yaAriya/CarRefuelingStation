package loader;

import exception.InvalidParametersException;
import exception.LoaderException;
import task.RefuelTask;
import validator.Validator;
import validator.ValidatorImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RefuellingParametersLoader {
    private static final String FILE_PATH = "src/main/resources/refuelingParameters.properties";
    private final Validator validator = new ValidatorImpl();
    private int fuelPumpsCount;
    private int maxWaitTime;

    private int carsCount;
    private int minTankValue;
    private int maxTankValue;

    public RefuellingParametersLoader() throws LoaderException {
        loadParameters();
    }

    public void loadParameters() throws LoaderException {
        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream(FILE_PATH);
            properties.load(inputStream);
            inputStream.close();

            String stringFuelPumpsCount = properties.getProperty("fuelPumpsCount");
            fuelPumpsCount = Integer.parseInt(stringFuelPumpsCount);

            String stringMaxWaitTime = properties.getProperty("maxWaitTime");
            maxWaitTime = Integer.parseInt(stringMaxWaitTime);

            String StringCarsCount = properties.getProperty("carsCount");
            carsCount = Integer.parseInt(StringCarsCount);

            String stringMinTankValue = properties.getProperty("minTankValue");
            minTankValue = Integer.parseInt(stringMinTankValue);

            String stringMaxTankValue = properties.getProperty("maxTankValue");
            maxTankValue = Integer.parseInt(stringMaxTankValue);

            boolean parametersIsValid = validator.validateRefuelingParameters(fuelPumpsCount, maxWaitTime, carsCount, minTankValue, maxTankValue);
            if(parametersIsValid){
                RefuelTask refuelTask = new RefuelTask(fuelPumpsCount, maxWaitTime, carsCount, minTankValue, maxTankValue);
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

    public int getFuelPumpsCount() {
        return fuelPumpsCount;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public int getMinTankValue() {
        return minTankValue;
    }

    public int getMaxTankValue() {
        return maxTankValue;
    }
}
