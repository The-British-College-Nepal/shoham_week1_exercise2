package vehicles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetManager {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        vehicles.add(vehicle);
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public int getTotalPassengerCapacity() {
        int totalCapacity = 0;

        for (Vehicle vehicle : vehicles) {
            totalCapacity += vehicle.getPassengerCapacity();
        }

        return totalCapacity;
    }

    public Vehicle findFastestVehicle() {
        if (vehicles.isEmpty()) {
            return null;
        }

        Vehicle fastest = vehicles.get(0);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() > fastest.getMaxSpeed()) {
                fastest = vehicle;
            }
        }

        return fastest;
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
}