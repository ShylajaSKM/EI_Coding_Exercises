package com.smart_home_system.devices;

public class ThermoStat extends Device {
    private int temperature = 70;

    public ThermoStat(int id) { super(id); }

    public int getTemperature() { return temperature; }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        this.status = "temperature set to " + temperature;
        notifyObservers();
    }
}
