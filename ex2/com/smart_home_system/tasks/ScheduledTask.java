package com.smart_home_system.tasks;

import com.smart_home_system.devices.Device;

public class ScheduledTask {
    private final Device device;
    private final String time;
    private final String action;

    public ScheduledTask(Device device, String time, String action) {
        this.device = device;
        this.time = time;
        this.action = action;
    }

    public Device getDevice() { return device; }

    @Override
    public String toString() {
        return "Task for Device " + device.getId() + " at " + time + " -> " + action;
    }
}
