package com.smart_home_system.tasks;

import com.smart_home_system.devices.Device;
import com.smart_home_system.devices.DeviceProxy;
import com.smart_home_system.devices.ThermoStat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutomatedTrigger {
    private final int triggerId;
    private final String condition; 
    private final String action;    
    private final Device checkDevice; 
    private int intervalInSeconds;
    private java.util.TimerTask timerTask;

    private static final Pattern ACTION_PATTERN = Pattern.compile("^\\s*([a-zA-Z_]+)\\s*\\(\\s*(\\d+)\\s*\\)\\s*$");

    public AutomatedTrigger(String type, String relation, int value, String action, Device checkDevice, int triggerId,
            int interval) {
        this.condition = type + " " + relation + " " + value;
        this.action = action;
        this.checkDevice = checkDevice;
        this.triggerId = triggerId;
        this.setIntervalInSeconds(interval);
    }

    public java.util.TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(java.util.TimerTask task) {
        this.timerTask = task;
    }

    public int getTriggerId() {
        return triggerId;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }

    public int getIntervalInSeconds() {
        return intervalInSeconds;
    }

    public void setIntervalInSeconds(int intervalInSeconds) {
        this.intervalInSeconds = intervalInSeconds;
    }

    public boolean isTriggered() {
        
        String[] parts = condition.trim().split("\\s+");
        if (parts.length != 3)
            return false;

        String operator = parts[1];
        int value;
        try {
            value = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        /
        ThermoStat thermostat = null;
        Device candidate = checkDevice;
        if (candidate instanceof DeviceProxy) {
            candidate = ((DeviceProxy) candidate).getRealDevice();
        }
        if (candidate instanceof ThermoStat) {
            thermostat = (ThermoStat) candidate;
        } else {
            return false; 
        }

        int current = thermostat.getTemperature();
        switch (operator) {
            case "=":
                return current == value;
            case ">":
                return current > value;
            case "<":
                return current < value;
            case ">=":
                return current >= value;
            case "<=":
                return current <= value;
            default:
                return false;
        }
    }

    
    public void execute(Map<Integer, Device> devices) {
        Matcher m = ACTION_PATTERN.matcher(action);
        if (!m.find()) {
            System.out.println("AutomatedTrigger: Invalid action format: " + action);
            return;
        }
        String actionName = m.group(1);
        int targetDeviceId;
        try {
            targetDeviceId = Integer.parseInt(m.group(2));
        } catch (NumberFormatException e) {
            System.out.println("AutomatedTrigger: Invalid device id in action: " + action);
            return;
        }

        Device target = devices.get(targetDeviceId);
        if (target == null) {
            System.out.println("AutomatedTrigger: Target device " + targetDeviceId + " not found.");
            return;
        }

        if (actionName.equalsIgnoreCase("turnOn") || actionName.equalsIgnoreCase("TurnOn")) {
            target.turnOn();
        } else if (actionName.equalsIgnoreCase("turnOff") || actionName.equalsIgnoreCase("TurnOff")) {
            target.turnOff();
        } else {
            System.out.println("AutomatedTrigger: Unknown action name: " + actionName);
        }
    }
}
