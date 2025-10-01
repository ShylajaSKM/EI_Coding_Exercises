package com.smart_home_system.devices;

public class DoorLock extends Device {
    public DoorLock(int id) { super(id); this.status = "locked"; }

    public void lock() { this.status = "locked"; notifyObservers(); }

    public void unlock() { this.status = "unlocked"; notifyObservers(); }
}
