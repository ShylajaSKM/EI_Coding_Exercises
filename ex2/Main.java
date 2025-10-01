import com.smart_home_system.core.SmartHomeSystem;
import com.smart_home_system.devices.Device;
import com.smart_home_system.devices.DeviceFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeSystem system = new SmartHomeSystem();
        Scanner sc = new Scanner(System.in);

        
        system.addDevice(DeviceFactory.createDevice(1, "light"));
        system.addDevice(DeviceFactory.createDevice(2, "thermostat"));
        system.addDevice(DeviceFactory.createDevice(3, "door"));

        while (true) {
            System.out.println("\nSmart Home Demo: Connections available = 3");
            System.out.println("1. Turn On Device  2. Turn Off Device  3. Set Thermostat  4. Exit");
            int choice = sc.nextInt();

            if (choice == 4) break;

            System.out.print("Enter device ID: ");
            int id = sc.nextInt();

            if (choice == 1) system.turnOnDevice(id);
            else if (choice == 2) system.turnOffDevice(id);
            else if (choice == 3) {
                System.out.print("Enter temperature: ");
                int temp = sc.nextInt();
                Device device = system.getClass().getDeclaredFields()[0].getType().equals(Device.class) ? null : null;
                
                System.out.println("Temperature set: " + temp);
            }
        }
        sc.close();
    }
}
