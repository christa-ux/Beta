package Backend.SMModules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationParametersFileManager {
    private static final String FILENAME = "simulation_parameters.txt";

    public static void saveParameters(List<SimulationParameters> parameters) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(parameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SimulationParameters> loadParameters() {
        List<SimulationParameters> parameters = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            parameters = (List<SimulationParameters>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parameters;
    }
}