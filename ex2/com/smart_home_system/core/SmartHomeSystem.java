package com.smart_home_system.core;

import com.smart_home_system.devices.*;
import com.smart_home_system.tasks.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SmartHomeSystem implements DeviceObserver {
    private final Map<Integer, Device> devices;
    private final List<ScheduledTask> scheduledTasks;
    private final List<AutomatedTrigger> automatedTriggers;
    private final Set<Integer> ids;
    private Timer timer; 

    public SmartHomeSystem() {
        devices = new HashMap<>();
        scheduledTasks = new ArrayList<>();
        automatedTriggers = new ArrayList<>();
        ids = new HashSet<>();
    }

    public void addDevice(int id, String type) {
        if (ids.contains(id)) {
            System.out.println("Error: Device ID already exists. Enter a unique id.");
            return;
        }
        Device real = DeviceFactory.createDevice(id, type);
        Device proxy = new DeviceProxy(real);
        
        proxy.addObserver(this);
        ids.add(id);
        devices.put(id, proxy);
        System.out.println("Device added: ID=" + id + ", type=" + type);
    }

    public void removeDevice(int id) {
        if (devices.containsKey(id)) {
            devices.remove(id);
            ids.remove(id);
            System.out.println("Device " + id + " removed successfully.");
        } else {
            System.out.println("Device ID " + id + " does not exist.");
        }
    }

    public void turnOn(int id) {
        Device d = devices.get(id);
        if (d == null) {
            System.out.println("Device ID " + id + " not found.");
            return;
        }
        d.turnOn();
    }

    public void turnOff(int id) {
        Device d = devices.get(id);
        if (d == null) {
            System.out.println("Device ID " + id + " not found.");
            return;
        }
        d.turnOff();
    }

    public void toggleOnOff(int id, int value) {
        if (!devices.containsKey(id)) {
            System.out.println("Error: Device ID " + id + " not found.");
            return;
        }
        if (value == 0) turnOff(id);
        else if (value == 1) turnOn(id);
        else System.out.println("Error: Invalid toggle value. Use 0 for off, 1 for on.");
    }

    public void scheduleDevice(int deviceId, String time, String action) {
        Device device = devices.get(deviceId);
        if (device == null) {
            System.out.println("scheduleDevice: Device not found: " + deviceId);
            return;
        }
        ScheduledTask task = new ScheduledTask(device, time, action);
        scheduledTasks.add(task);
        scheduleTaskExecution(task);
        System.out.println("Scheduled task: device=" + deviceId + ", time=" + time + ", action=" + action);
    }

    private void scheduleTaskExecution(ScheduledTask task) {
        
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.execute();
            }
        }, parseTime(task.getTime()));
    }

    private long parseTime(String timeString) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long milliseconds = 0;
        try {
            Date date = sdf.parse(timeString);
            milliseconds = date.getTime();
        } catch (Exception e) {
            System.out.println("parseTime: Invalid time format. Use HH:mm");
        }
        return milliseconds;
    }

    public void addAutomatedTrigger(String type, String relation, int value, String action, int intervalInSeconds,
            int triggerId) {
        int checkDeviceId = -1;
        for (int id : devices.keySet()) {
            if (devices.get(id).getType().equalsIgnoreCase(type)) {
                checkDeviceId = id;
                break;
            }
        }
        if (checkDeviceId == -1) {
            System.out.println("addAutomatedTrigger: No device of type '" + type + "' found.");
            return;
        }
        AutomatedTrigger trigger = new AutomatedTrigger(type, relation, value, action, devices.get(checkDeviceId),
                triggerId, intervalInSeconds);
        automatedTriggers.add(trigger);
        startAutomatedTriggerChecking(intervalInSeconds, trigger);
        System.out.println("Added automated trigger: id=" + triggerId + ", condition=" + trigger.getCondition()
                + ", action=" + action + ", interval=" + intervalInSeconds + "s");
    }

    public void startAutomatedTriggerChecking(int intervalInSeconds, AutomatedTrigger trigger) {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                checkAutomatedTriggers();
            }
        };
        t.scheduleAtFixedRate(task, 0, intervalInSeconds * 1000L);
        trigger.setTimerTask(task);
    }

    public void changeTriggerCheckingInterval(int targetTriggerId, int newInterval) {
        boolean restarted = false;
        for (AutomatedTrigger trig : automatedTriggers) {
            if (trig.getTriggerId() == targetTriggerId) {
                java.util.TimerTask old = trig.getTimerTask();
                if (old != null) {
                    old.cancel();
                }
                trig.setIntervalInSeconds(newInterval);
                startAutomatedTriggerChecking(newInterval, trig);
                restarted = true;
                System.out.println("Trigger " + targetTriggerId + " interval changed to " + newInterval + " seconds.");
            }
        }
        if (!restarted) {
            System.out.println("changeTriggerCheckingInterval: Trigger id " + targetTriggerId + " not found.");
        }
    }

    public void checkAutomatedTriggers() {
        for (AutomatedTrigger trigger : automatedTriggers) {
            try {
                if (trigger.isTriggered()) {
                    trigger.execute(devices);
                }
            } catch (Exception e) {
                System.out.println("Error checking trigger " + trigger.getTriggerId() + ": " + e.getMessage());
            }
        }
    }

    public void statusReport() {
        System.out.println("Status Report:");
        for (int id : devices.keySet()) {
            Device d = devices.get(id);
            if (d == null) continue;
            if (d instanceof DeviceProxy) {
                
                Device real = ((DeviceProxy) d).getRealDevice();
                if (real instanceof ThermoStat) {
                    System.out.println("thermostat is set to " + ((ThermoStat) real).getTemperature());
                    continue;
                }
            } else if (d instanceof ThermoStat) {
                System.out.println("thermostat is set to " + ((ThermoStat) d).getTemperature());
                continue;
            }
            System.out.println(d.getType() + " " + d.getId() + " " + d.getStatus());
        }
    }

    public void scheduledTask() {
        System.out.print("[");
        for (ScheduledTask x : scheduledTasks) {
            System.out.print("{device:" + x.getDevice().getId() + ", time: \"" + x.getTime() + "\", command: \""
                    + x.getAction() + "\"}");
        }
        System.out.println("]");
    }

    public void automatedTriggers() {
        System.out.print("[");
        for (AutomatedTrigger x : automatedTriggers) {
            System.out.print("{TriggerId: " + x.getTriggerId() + ", condition:" + x.getCondition() + ", action: \""
                    + x.getAction() + "\", Interval:" + x.getIntervalInSeconds() + "}");
        }
        System.out.println("]");
    }

    public int presentInterval(int targetTriggerId) {
        for (AutomatedTrigger x : automatedTriggers) {
            if (x.getTriggerId() == targetTriggerId) {
                return x.getIntervalInSeconds();
            }
        }
        return 0;
    }

   
    @Override
    public void update(Device device) {
        System.out.println("Observer: Device " + device.getId() + " (" + device.getType() + ") changed to "
                + device.getStatus());
       
        checkAutomatedTriggers();
    }
}
