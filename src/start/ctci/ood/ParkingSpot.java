package start.ctci.ood;

import java.util.List;

enum VehicleSize {
	Large, Compact, Motorcycle
}

abstract class Vehicle {

	int spotsNeeded;
	VehicleSize size;
	List<ParkingSpot> spots;
	
	
	void parkInSpot(ParkingSpot ps) {
		spots.add(ps);
	}
	
	void clearSpot() {}
	
	abstract boolean canFitInSpot(ParkingSpot spot);
}

class Bus extends Vehicle {
	
	public Bus() {
		spotsNeeded=5;
		size=VehicleSize.Large;
	}
	
	boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}

class Car extends Vehicle {
	
	public Car() {
		spotsNeeded=1;
		size=VehicleSize.Compact;
	}

	boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}

class Motorcycle extends Vehicle {
	public Motorcycle() {
		spotsNeeded=1;
		size=VehicleSize.Motorcycle;
	}

	boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}

class ParkingLot {

	Level[] levels;
	int num_levels = 5;
	
	boolean parkVehicle(Vehicle v) {
		return false;	
	}
}

class Level {
	int floor;
	ParkingSpot[] spots;
	int availableSpots =0 ;
	int spotsPerRow = 10;
	
	
	boolean parkVehicle(Vehicle v) {
		return false;
	}
	
	boolean parkAtStartingPoint(int num, Vehicle v) {
		return false;
	}
	
	int findAvailableSpot(Vehicle v) { return 0;}
	void freeSpot() {}
}


public class ParkingSpot {
	Vehicle vehicle;
	VehicleSize size;
	int row;
	int spotNumber;
	Level level;
	
	boolean isAvailable() { return vehicle==null;}
	
	boolean canFitVehicle() { return false;}
	
	boolean park(Vehicle vehicle) { return false;}
	
	void removeVehicle() {}	
}
