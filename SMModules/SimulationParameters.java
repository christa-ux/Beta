package Backend.SMModules;

import java.io.Serializable;

public class SimulationParameters implements Serializable {
    private String location;
    private String date;
    private String time;
    private double temperature;
    private boolean deviceState;

    public SimulationParameters() {
        // Default constructor
    }

    public SimulationParameters(String location, String date, String time, double temperature, boolean deviceState) {
        this.location = location;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.deviceState = deviceState;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isDeviceState() {
        return deviceState;
    }

    public void setDeviceState(boolean deviceState) {
        this.deviceState = deviceState;
    }
}
