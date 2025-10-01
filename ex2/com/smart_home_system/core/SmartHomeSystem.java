package com.smart_home_system.core;

import com.smart_home_system.devices.*;
import com.smart_home_system.tasks.*;

import java.util.*;

public class SmartHomeSystem implements DeviceObserver {
    private final Map<Integer, Device> devices = new HashMap<>();
    private final List<ScheduledTask> scheduledTasks = new ArrayList<>();
    private final List<AutomatedTrigger> automatedTriggers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
        LoggerUtility.info("Device added: " + device);
    }

    public void removeDevice(int id) {
        if (devices.containsKey(id)) {
            devices.remove(id);
            LoggerUtility.info("Device removed: " + id);
        } else {
            LoggerUtility.warning("Attempted to remove non-existent device: " + id);
        }
    }

    public void turnOnDevice(int deviceId) {
        Device device = devices.get(deviceId);
        if (device != null) {
            device.turnOn();
            LoggerUtility.info("Device " + deviceId + " turned ON");
        } else {
            LoggerUtility.warning("Device " + deviceId + " not found");
        }
    }

    public void turnOffDevice(int deviceId) {
        Device device = devices.get(deviceId);
        if (device != null) {
            device.turnOff();
            LoggerUtility.info("Device " + deviceId + " turned OFF");
        } else {
            LoggerUtility.warning("Device " + deviceId + " not found");
        }
    }

    public void scheduleTask(int deviceId, String time, String action) {
        Device device = devices.get(deviceId);
        if (device != null) {
            ScheduledTask task = new ScheduledTask(device, time, action);
            scheduledTasks.add(task);
            LoggerUtility.info("Scheduled task: " + task);
        } else {
            LoggerUtility.warning("Cannot schedule task. Device not found: " + deviceId);
        }
    }

    public void addTrigger(String type, String relation, int value, String action, int checkDeviceId) {
        Device device = devices.get(checkDeviceId);
        if (device != null) {
            AutomatedTrigger trigger = new AutomatedTrigger(type, relation, value, action, device);
            automatedTriggers.add(trigger);
            LoggerUtility.info("Added automated trigger: " + trigger);
        } else {
            LoggerUtility.warning("Cannot add trigger. Device not found: " + checkDeviceId);
        }
    }

    @Override
    public void update(Device device) {
        LoggerUtility.info("Device " + device.getId() + " status updated: " + device.getStatus());
    }
}
