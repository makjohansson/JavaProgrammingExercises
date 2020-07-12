package mj223vn_assign1.exercise2;
import java.util.*;
public abstract class Vehicle {
	
	private int maxPassengers;
	private int size;
	private List<Passenger> passengers;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int maxPassangers, int size) {
		this.maxPassengers = maxPassangers;
		this.size = size;
		passengers = new ArrayList<Passenger>();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getMaxPassagers() {
		return maxPassengers;
	}
	
	public List<Passenger> getPassagers(){
		return this.passengers;
	}
	
	public boolean addPassenger(Passenger p) {
		if(passengers.size() <= maxPassengers) {
			return passengers.add(p);
		}
		else
			return false;
	}
}
