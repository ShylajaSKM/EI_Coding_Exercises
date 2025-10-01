package com.smart_home_system.tasks;

import com.smart_home_system.devices.Device;

public class AutomatedTrigger {
    private final String type;
    private final String relation;
    private final int value;
    private final String action;
    private final Device device;

    public AutomatedTrigger(String type, String relation, int value, String action, Device device) {
        this.type = type;
        this.relation = relation;
        this.value = value;
        this.action = action;
        this.device = device;
    }

    @Override
    public String toString() {
        return "Trigger: if " + type + " " + relation + " " + value + " then " + action + " on device " + device.getId();
    }
}
