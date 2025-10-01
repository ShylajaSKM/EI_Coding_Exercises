package com.smart_home_system.devices;

import java.util.ArrayList;
import java.util.List;

public abstract class Device implements ObservableDevice {
    protected int id;
    protected String status;
    private final List<DeviceObserver> observers = new ArrayList<>();

    public Device(int id) {
        this.id = id;
        this.status = "idle";
    }

    public int getId() { return id; }

    public String getStatus() { return status; }

    public void turnOn() { status = "on"; notifyObservers(); }

    public void turnOff() { status = "off"; notifyObservers(); }

    @Override
    public void addObserver(DeviceObserver observer) { observers.add(observer); }

    @Override
    public void removeObserver(DeviceObserver observer) { observers.remove(observer); }

    @Override
    public void notifyObservers() {
        for (DeviceObserver observer : observers) observer.update(this);
    }

    @Override
    public String toString() { return this.getClass().getSimpleName() + " ID:" + id + " Status:" + status; }
}
