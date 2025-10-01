package com.smart_home_system.devices;

public class DoorLock extends Device {
    public DoorLock(int id) {
        super(id, "door");
        this.status = "locked";
    }

    @Override
    public void turnOn() {
        status = "locked";
        notifyObservers();
    }

    @Override
    public void turnOff() {
        status = "unlocked";
        notifyObservers();
    }
}
