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

    public void execute() {
        if (action.equalsIgnoreCase("Turn On")) {
            device.turnOn();
        } else if (action.equalsIgnoreCase("Turn Off")) {
            device.turnOff();
        } else {
            System.out.println("ScheduledTask: Unknown action \"" + action + "\"");
        }
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public Device getDevice() {
        return device;
    }
}
