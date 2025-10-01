package com.smart_home_system.devices;

public interface ObservableDevice {
    void addObserver(DeviceObserver observer);
    void removeObserver(DeviceObserver observer);
    void notifyObservers();
}
