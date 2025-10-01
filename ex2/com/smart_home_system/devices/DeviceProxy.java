package com.smart_home_system.devices;

public class DeviceProxy extends Device {
    private final Device realDevice;

    public DeviceProxy(Device realDevice) {
        super(realDevice.getId());
        this.realDevice = realDevice;
    }

    public Device getRealDevice() { return realDevice; }

    @Override public void turnOn() { realDevice.turnOn(); }

    @Override public void turnOff() { realDevice.turnOff(); }

    @Override public void notifyObservers() { realDevice.notifyObservers(); }
}
