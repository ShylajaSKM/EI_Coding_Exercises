import com.smart_home_system.core.SmartHomeSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeSystem homeSystem = new SmartHomeSystem();
        Scanner scanner = new Scanner(System.in);

        
        homeSystem.addDevice(1, "light");
        homeSystem.addDevice(2, "thermostat");
        homeSystem.addDevice(3, "door");

       
        homeSystem.scheduleDevice(2, "06:00", "Turn On");
        homeSystem.addAutomatedTrigger("thermostat", ">", 75, "turnOff(1)", 60, 1);

        outerLoop: while (true) {
            System.out.println("1.Status Report\n2.ScheduledTasks\n3.Automated Triggers\n4.Add Device\n5.Remove Device\n6.Toggle Device\n7.ChangeTriggerIntervalForSpecifiedTrigger\n0.Exit");
            System.out.print("Choose option: ");
            int option;
            try {
                option = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    homeSystem.statusReport();
                    break;
                case 2:
                    homeSystem.scheduledTask();
                    break;
                case 3:
                    homeSystem.automatedTriggers();
                    break;
                case 4:
                    System.out.print("Enter an id for device: ");
                    int id = Integer.parseInt(scanner.next());
                    System.out.print("Enter a type of device (light/thermostat/door): ");
                    String type = scanner.next();
                    homeSystem.addDevice(id, type);
                    break;
                case 5:
                    System.out.print("Enter device id to remove: ");
                    int removeId = Integer.parseInt(scanner.next());
                    homeSystem.removeDevice(removeId);
                    break;
                case 6:
                    System.out.print("Enter an id for device: ");
                    int targetDeviceId = Integer.parseInt(scanner.next());
                    System.out.print("Enter 1 for on and 0 for off: ");
                    int value = Integer.parseInt(scanner.next());
                    homeSystem.toggleOnOff(targetDeviceId, value);
                    break;
                case 7:
                    System.out.print("Enter trigger id: ");
                    int targetTriggerId = Integer.parseInt(scanner.next());
                    System.out.println("Current interval of the mentioned trigger is " + homeSystem.presentInterval(targetTriggerId));
                    System.out.print("Interval you want to keep (seconds): ");
                    int newInterval = Integer.parseInt(scanner.next());
                    homeSystem.changeTriggerCheckingInterval(targetTriggerId, newInterval);
                    break;
                case 0:
                    break outerLoop;
                default:
                    System.out.println("Unknown option. Try again.");
            }
            System.out.println();
        }

        
    }
}
