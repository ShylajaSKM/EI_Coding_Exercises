package com.smart_home_system.devices;

import java.util.ArrayList;
import java.util.List;

public class Device implements ObservableDevice {
    protected final int id;
    protected final String type;
    protected String status;
    private List<DeviceObserver> observers = new ArrayList<>();

    public Device(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public void turnOn() {
        status = "on";
        notifyObservers();
    }

    public void turnOff() {
        status = "off";
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    
    @Override
    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DeviceObserver observer : observers) {
            observer.update(this);
        }
    }
}
