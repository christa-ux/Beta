package Backend.HouseLayout;

import java.util.ArrayList;
import java.util.List;
import Backend.SMModules.SHHObserver;

public class Room {
    private String roomId;
    private String zoneId;
    private double currentTemperature;
    private boolean isOccupied;
    private double temperatureWhenOccupied;
    private double temperatureWhenUnoccupied;
    private List<SHHObserver> observers = new ArrayList<>(); // Observers that are interested in room updates

    // Constructors
    public Room(String roomId, String zoneId, double temperatureWhenOccupied, double temperatureWhenUnoccupied) {
        this.roomId = roomId;
        this.zoneId = zoneId;
        this.currentTemperature = 20.0; // Default starting temperature
        this.isOccupied = false;
        this.temperatureWhenOccupied = temperatureWhenOccupied;
        this.temperatureWhenUnoccupied = temperatureWhenUnoccupied;
    }

    // Observer registration methods
    public void addObserver(SHHObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SHHObserver observer) {
        observers.remove(observer);
    }

    // Notify all registered observers about changes
    private void notifyObservers(String eventType) {
        for (SHHObserver observer : observers) {
            observer.update(this.roomId, eventType, this); // Pass 'this' as eventData for observers to utilize Room
                                                           // data
        }
    }

    // Methods
    public void adjustTemperature(double temperature) {
        this.currentTemperature = temperature;
        System.out.println("Temperature of room " + roomId + " adjusted to " + temperature);
    }

    public void updateTemperatureBasedOnOccupancy() {
        double targetTemperature = isOccupied ? temperatureWhenOccupied : temperatureWhenUnoccupied;
        adjustTemperature(targetTemperature);
        System.out.println("Room " + roomId + " temperature adjusted based on occupancy to " + targetTemperature);
    }

    public void setOccupancy(boolean isOccupied) {
        this.isOccupied = isOccupied;
        System.out.println("Room " + roomId + " occupancy set to " + isOccupied);
        updateTemperatureBasedOnOccupancy();
        notifyObservers("OccupancyChange"); // Notify observers about the occupancy change
    }

    // Automated method to simulate temperature changes over time
    public void simulateTemperatureChange(double externalFactor) {
        double change = externalFactor * (Math.random() - 0.5);
        adjustTemperature(this.currentTemperature + change);
    }

    // Getters and Setters
    public String getRoomId() {
        return roomId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public double getTemperatureWhenOccupied() {
        return temperatureWhenOccupied;
    }

    public double getTemperatureWhenUnoccupied() {
        return temperatureWhenUnoccupied;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", zoneId='" + zoneId + '\'' +
                ", currentTemperature=" + currentTemperature +
                ", isOccupied=" + isOccupied +
                ", temperatureWhenOccupied=" + temperatureWhenOccupied +
                ", temperatureWhenUnoccupied=" + temperatureWhenUnoccupied +
                '}';
    }

    public Window getWindow() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWindow'");
    }
}
