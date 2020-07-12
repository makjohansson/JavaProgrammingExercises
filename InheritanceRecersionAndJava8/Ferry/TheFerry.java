package mj223vn_assign1.exercise2;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class TheFerry implements Ferry{
	private int maxCapacity = 200;
	private int maxPassengers = 200;
	private int numOfPassengers;
	private int spaceOnFerry;
	private int totalMoney;;
	private List<Passenger> passengers;
	private List<Vehicle> vehicle;
	
	public TheFerry() {
		passengers = new ArrayList<Passenger>();
		vehicle = new ArrayList<Vehicle>();
		numOfPassengers = 0;
		spaceOnFerry = 0;
		totalMoney = 0;
	}
	
	
	public int countPassengers() {
		return passengers.size();	
	}
	
	public int getMoney() {
		return totalMoney;
	}

	
	public int countVehicleSpace() {	
		return spaceOnFerry;
	}

	
	public int countMoney() {
		Iterator<Vehicle> iterator = vehicle.iterator();
		int moneyCounter = 0;
		int passenger = 0;
		while(iterator.hasNext()) {
			Vehicle a = iterator.next();
			if(a instanceof Bus) {
				moneyCounter += 200;
				List<Passenger> lp = a.getPassagers();
				moneyCounter += lp.size() * 15;
				passenger += lp.size();
			}
			if(a instanceof Car) {
				moneyCounter += 100;
				List<Passenger> lp = a.getPassagers();
				moneyCounter += lp.size() * 20;
				passenger += lp.size();
			}
			if(a instanceof Lorry) {
				moneyCounter += 300;
				List<Passenger> lp = a.getPassagers();
				moneyCounter += lp.size() * 20;
				passenger += lp.size();
			}
			if(a instanceof Bike) {
				moneyCounter += 40;
				passenger++;
			}
		}
		moneyCounter += (passengers.size() - passenger) * 25;
		totalMoney += moneyCounter;
		return totalMoney;
	}

	
	public Iterator<Vehicle> iterator() {
		return vehicle.iterator();	
	}

	
	public void embark(Vehicle v) {
		if((maxCapacity - spaceOnFerry) >= v.getSize()) {
			if((maxPassengers - numOfPassengers) >= v.getPassagers().size()) {
				vehicle.add(v);
				spaceOnFerry += v.getSize();
				numOfPassengers += v.getPassagers().size();
				passengers.addAll(v.getPassagers());
			}
		}
		
	}

	
	public void embark(Passenger p) {
		if(hasRoomFor(p)) {
			passengers.add(p);
			numOfPassengers++;
		}
	}

	
	public void disembark() {
		passengers = new ArrayList<Passenger>();
		vehicle = new ArrayList<Vehicle>();
		numOfPassengers = 0;
		spaceOnFerry  = 0;
	}

	
	public boolean hasSpaceFor(Vehicle v) {
		
		if(spaceOnFerry <= (maxCapacity - v.getSize()) && maxPassengers >= (numOfPassengers + v.getPassagers().size())) {
			return true;
		}
		return false;
	}

	
	public boolean hasRoomFor(Passenger p) {
		if(numOfPassengers <=  maxPassengers) {
			return true;
		}
		return false;
	}

}
