package com.smart_home_system.devices;

public class DeviceProxy extends Device {
    private final Device realDevice;

    public DeviceProxy(Device realDevice) {
        super(realDevice.getId(), realDevice.getType());
        this.realDevice = realDevice;
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Accessing " + realDevice.getType() + " " + realDevice.getId());
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Accessing " + realDevice.getType() + " " + realDevice.getId());
        realDevice.turnOff();
    }

    
    public Device getRealDevice() {
        return realDevice;
    }
}
